package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServerTest {
    private ServerSocket serverSocket = null;
    // 创建线程池
    private ExecutorService service = Executors.newCachedThreadPool();

    public TcpServerTest(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    private void start() throws IOException {
        System.out.println("服务器启动!!!");
        // 先让跑腿小哥接客
        Socket socket = serverSocket.accept();
        service.submit(new Runnable() {
            @Override
            public void run() {
                myProcessConnection(socket);
            }
        });
    }
    public void myProcessConnection(Socket clientSocket) {
        // 打印个日志先
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        try (
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                ) {
            while (true) {
                // 1、先看用户的需求是什么
                // 使用 Scanner 读取
                Scanner sc = new Scanner(inputStream);
                // 判断客户端数据是否输入完成了
                if (!sc.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    break;
                }
                String request = sc.nextLine();
                // 2、处理请求
                String response = process(request);
                // 3、打包成 PrintWriter 类型
                PrintWriter writer = new PrintWriter(outputStream);
                // 4、发送给客户端
                writer.println(response);
                writer.flush();
                // 打印日志
                System.out.printf("客户端ip及端口号[%s:%d]\n输入: %s, 响应: %s\n",
                        clientSocket.getInetAddress().toString(), clientSocket.getPort(), request, response
                        );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            // 在 finally 中加上 close 操作, 确保当前 socket 被及时关闭!!!
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpServerTest tcpServerTest = new TcpServerTest(9090);
        tcpServerTest.start();
    }
}

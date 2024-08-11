package boKe.myTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {
    private ExecutorService service = Executors.newCachedThreadPool();
    private ServerSocket serverSocket= null;

    public TCPServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("My TCP 服务器启动!!!");
        while (true) {
            // 首先得拿到客户端请求报文
            Socket lianJie = serverSocket.accept();
            // 再处理请求
            service.submit(() -> {
                processLianJie(lianJie);
            });
        }
    }

    private void processLianJie(Socket lianJie) {
        // 打印一个日志
        System.out.printf("[%s:%d] 客户端上线!\n",
                lianJie.getInetAddress().toString(),
                lianJie.getPort()
                );
        // 读取客户端请求
        try (
                InputStream inputStream = lianJie.getInputStream();
                OutputStream outputStream = lianJie.getOutputStream();
                ) {
            while (true) {
                // 直接使用 Scanner 来读取请求
                Scanner sc = new Scanner(inputStream);
                if (!sc.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线!\n",
                            lianJie.getInetAddress().toString(),
                            lianJie.getPort()
                    );
                    break;
                }
                // 拿到连接之后先读取客户端的请求
                String qingQiu = sc.next();
                String xiangYing = process(qingQiu);
                // 处理好之后直接打包成文件发过去
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(xiangYing);
                // 还得记得关闭这个文件操作
                printWriter.flush();
                // 打印一个日志
                System.out.printf("客户端ip及端口号[%s:%d]\n输入: %s, 响应: %s\n",
                        lianJie.getInetAddress().toString(),
                        lianJie.getPort(),
                        qingQiu.replace("\n", ""),// 替换字符串，把最后一个"\n"替换成 ""，避免换行
                        xiangYing.replace("\n", "")
                        );
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String process(String qingQiu) throws InterruptedException {
        return qingQiu;
    }

    public static void main(String[] args) throws IOException {
        TCPServer tcpServer = new TCPServer(9090);
        tcpServer.start();
    }
}

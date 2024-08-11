package myTcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    // 为了避免频繁的创建和销毁线程，而且不应该使用固定数量的线程池，所以使用可变的线程池更为优选!!!
    private ExecutorService service = Executors.newCachedThreadPool();

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!!!");
        while (true) {
            // 1、拿到客户端的请求
            Socket clientSocket = serverSocket.accept();

            // 2、处理响应
            //processConnection(clientSocket);

            // 单个线程, 不太方便完成这里的一边拉客, 一边介绍. 就需要多搞线程. 主线程专门负责拉客. 每次有一个客户端, 都创建一个新的线程去服务
            /*Thread t = new Thread(() -> {
                processConnection(clientSocket);
            });
            t.start();*/

            // 使用线程池, 来解决上述问题
            service.submit(new Runnable() {
                @Override
                public void run() {
                    myProcessConnection(clientSocket);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        // 读取请求
        try (
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
        ) {
            while (true) {
                // d读取客户端请求并解析，方便读取用 Scanner ，但是只能读文本文件
                Scanner sc = new Scanner(inputStream);
                // 判断客户端数据是否输入完成了
                if (!sc.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
                    break;
                }
                // 读取客户端数据
                String request = sc.next();
                // 处理客户端数据
                String response = process(request);
                // 处理好之后打包成 PrintWriter 类型的数据返回给客户端
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(response);
                // 清空缓冲区
                writer.flush();
                // 日志, 打印当前的请求详情.
                System.out.printf("客户端ip及端口号[%s:%d]\n输入: %s, 响应: %s\n", clientSocket.getInetAddress().toString(), clientSocket.getPort(),
                        request.replace("\n", ""), response.replace("\n", ""));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 在 finally 中加上 close 操作, 确保当前 socket 被及时关闭!!!
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void myProcessConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(), clientSocket.getPort());
        // 读取请求
        try (
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
        ) {
            while (true) {
                byte[] buf = new byte[8192];
                int n = inputStream.read(buf);
                if (n == -1) {
                    System.out.println("客户端强制退出!!!");
                    break;
                }
                // 做出响应
                String request = new String(buf, 0, n);
                String response = process(request);
                // 把返回值返回抛给服务器，得用 PrintWriter 包裹一下，方便发数据
                PrintWriter writer = new PrintWriter(outputStream);
                //    此处用 println, 而不是 print 就是为了在结尾加上 \n，方便客户端读取数据
                writer.println(response);
                // 清空一下缓冲区
                writer.flush();
                // 日志, 打印当前的请求详情.
                System.out.printf("客户端ip及端口号[%s:%d]\n输入: %s, 响应: %s\n", clientSocket.getInetAddress().toString(), clientSocket.getPort(),
                        request, response);
            }

        } catch (SocketException e) {
            // 客户端退出异常
            System.out.printf("[%s:%d] 连接异常（可能是客户端断开）: %s\n", clientSocket.getInetAddress().toString(), clientSocket.getPort(), e.getMessage());
        } catch (IOException e) {
            System.err.printf("[%s:%d] IO异常: %s\n", clientSocket.getInetAddress().toString(), clientSocket.getPort(), e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}

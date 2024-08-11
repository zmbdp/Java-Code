package myTcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        this.socket = new Socket(serverIp, serverPort);
    }

    private void start() {
        // 添加日志
        System.out.println("客户端启动!!!");
        // 输入请求
        Scanner sc = new Scanner(System.in);
        try (
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ) {
            while (true) {
                // 让用户输入请求
                System.out.print("请输入->");
                String request = sc.nextLine();
                // 打包成 PrintWriter 格式的文件发送给服务器，记得关闭 writer 文件!!!
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                // 从服务器读取响应，然后打印出来

                /*Scanner scannerNetwork = new Scanner(inputStream);
                String response = scannerNetwork.next();*/

                byte[] buf = new byte[8192];
                int n = inputStream.read(buf);
                String response = new String(buf, 0, n);
                System.out.println(response.trim());// 去除服务器发过来的换行符，因为输入过去时已经读取回车了!!!
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}

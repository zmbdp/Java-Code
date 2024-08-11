package boKe.myTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    private Socket socket = null;

    public TCPClient(String serverIp, int serverPort) throws IOException {
        this.socket = new Socket(serverIp, serverPort);
    }

    private void start() {
        // 打印一个日志
        System.out.println("My TCP 客户端启动!!!");
        Scanner sc = new Scanner(System.in);
        try (
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
        ) {
            while (true) {
                // 先输入你的请求
                System.out.print("请输入->");
                String qingQiu = sc.next();
                // 打包成 PrintWriter
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(qingQiu);// 使用 println 来发送，携带 \n ，让解包的时候更方便，不会产生粘包问题
                printWriter.flush();
                // 然后接收服务器的响应
                Scanner xiangYingSc = new Scanner(inputStream);
                String xiangYing = xiangYingSc.next();
                System.out.println(xiangYing);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TCPClient tcpClient = new TCPClient("127.0.0.1", 9090);
        tcpClient.start();
    }
}

package myUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    // 服务器的ip和端口号
    public UdpEchoClient(String ip, int port) throws SocketException {
        this.serverIp = ip;
        this.serverPort = port;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("客户端启动!!!");
        while (true) {
            // 先获取用户请求
            System.out.print("请输入->");
            String request = sc.next();
            // 包装成数据报，并发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(StandardCharsets.UTF_8), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort
            );
            socket.send(requestPacket);
            // 再根据服务器做出的响应，解析内容，并且打印出来
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
        udpEchoClient.start();
    }
}

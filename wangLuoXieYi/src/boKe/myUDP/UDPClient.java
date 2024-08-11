package boKe.myUDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    public UDPClient(String serverIp, int serverPort) throws SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        // 创建一个 DatagramSocket ，并让系统自动分配端口号
        this.socket = new DatagramSocket();
    }

    private void start() throws IOException {
        // 打印日志
        System.out.println("My UDP 客户端启动!!!");
        Scanner sc = new Scanner(System.in);
        // 想一直输入，一直看结果
        while (true) {
            System.out.print("请输入->");
            String qingQiu = sc.next();
            // 打包成一个 DatagramPacket 数据报，发送的内容，发送的目的地端口和 id
            DatagramPacket packet = new DatagramPacket(
                    qingQiu.getBytes(StandardCharsets.UTF_8)
                    , qingQiu.getBytes().length,
                    InetAddress.getByName(serverIp),
                    serverPort
            );
            // 通过 send 方法发送出去
            socket.send(packet);
            // 然后再接收服务器的响应
            DatagramPacket xiangYingShuJuBao = new DatagramPacket(new byte[4096], 4096);
            socket.receive(xiangYingShuJuBao);
            String xiangYing = new String(xiangYingShuJuBao.getData(), 0, xiangYingShuJuBao.getLength());
            System.out.println(xiangYing);
        }
    }

    public static void main(String[] args) throws IOException {
        UDPClient udpClient = new UDPClient("127.0.0.1", 9090);
        udpClient.start();
    }
}

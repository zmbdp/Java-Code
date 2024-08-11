import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
// 客户端
public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;
    public UdpEchoClient(String ip, int port) throws SocketException {
        this.serverIp = ip;
        this.serverPort = port;
        socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("keHuDuan");
        while (true) {
            System.out.print("->");
            String request = sc.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(StandardCharsets.UTF_8), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort
            );
            socket.send(requestPacket);
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

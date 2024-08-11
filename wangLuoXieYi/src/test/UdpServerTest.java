package test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpServerTest {
    private DatagramSocket socket = null;

    public UdpServerTest(int prom) throws SocketException {
        this.socket = new DatagramSocket(prom);
    }

    public void start() throws IOException {
        System.out.println("服务器启动!!!");
        while (true) {
            // 1、先创建一个数组，从服务器那拿到数据再说
            DatagramPacket packet = new DatagramPacket(new byte[4096], 4096);
            socket.receive(packet);
            String request = new String(packet.getData(), 0, packet.getLength());
            // 2、分析拿到的数据，然后处理得出响应
            String retProcess = process(request);
            //  打包成 DatagramPacket 发送给客户端
            DatagramPacket responsePacket = new DatagramPacket(retProcess.getBytes(StandardCharsets.UTF_8), retProcess.getBytes().length,
                    packet.getSocketAddress()// 得到 requestPacket 的 ip 地址
            );
            // 3、返回响应
            socket.send(responsePacket);
            // 打印日志，方便观察程序执行结果，先打印客户端 ip 地址，再打印端口号，再打印请求和响应
            System.out.printf("\n客户端ip地址及端口号[%s; %d]\n请求：%s; 响应：%s\n", packet.getAddress().toString(), packet.getPort(),
                    request, retProcess);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpServerTest udpServerTest = new UdpServerTest(9090);
        udpServerTest.start();
    }
}

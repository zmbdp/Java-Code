package boKe.myUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPServer {
    private DatagramSocket socket = null;

    public UDPServer(int port) throws SocketException {
        // 首先得创建一个服务器实例，端口号的话是要自己指定的，不然随机分配的话客户端那边不好访问
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        // 添加一个日志
        System.out.println("My UDP 服务器启动!!!");
        // 服务器要一直不停的工作
        while (true) {
            // 首先建立一个空的 DatagramSocket 数据报，然后把客户端的请求数据报装到这个数组里面
            DatagramPacket keHuDuan = new DatagramPacket(new byte[4096], 4096);
            // 接收客户端发送的请求数据报，这时候这个请求还是个数据报，我们得解析出请求
            socket.receive(keHuDuan);
            // 解析请求
            String qingQiu = new String(keHuDuan.getData(), 0, keHuDuan.getLength());
            // 对客户端的请求做出响应
            String xiangYing = process(qingQiu);
            // 然后再把我们的响应打包成一个数据报返还给客户端那边
            // 需要传递的参数：传递的内容，内容的长度以及传给谁？？
            DatagramPacket packet = new DatagramPacket(xiangYing.getBytes(StandardCharsets.UTF_8), // 传递的内容
                    xiangYing.length(), // 内容的长度
                    keHuDuan.getSocketAddress());// 得到客户端的 ip 地址
            socket.send(packet);
            // 最后打印一个日志，证明我们传好了
            System.out.printf("\n客户端端口号[%d]\n请求：%s; 响应：%s\n",
                    keHuDuan.getPort(),
                    qingQiu,
                    xiangYing
            );
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UDPServer udpServer = new UDPServer(9090);
        udpServer.start();
    }
}

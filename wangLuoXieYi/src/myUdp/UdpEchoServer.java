package myUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

// UDP的回显服务器
// 功能：客户端发的请求是什么，服务器的响应就是什么
public class UdpEchoServer {
    private DatagramSocket socket = null;

    // 将设定的端口号放入其中，这个端口号是服务器绑定的
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);// 申请 socket 对象，因为是服务器端口号所以要自己指定
    }

    public void start() throws IOException {
        // 使用 stack 方法启动服务器
        System.out.println("服务器启动");// 添加日志
        while (true) {
            // 1、首先接收请求，并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);// 先弄空的数据报，客户端那边是什么需求就往里面放，然后返回给你
            socket.receive(requestPacket);// 把数据报丢进去，让后台给你解析客户端发送的请求
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength());
            // 2、对请求做出相应
            String response = process(request);
            // 3、将相应返回给客户端
            // 得先告诉网卡发送的内容啊这些东西，建立一个数据报
            // 要发送的东西打包成一个字节数组，然后告诉它你这个数组的大小和客户端端口号
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(StandardCharsets.UTF_8), response.getBytes().length,
                    requestPacket.getSocketAddress()// 得到 requestPacket 的 ip 地址
            );
            socket.send(responsePacket);
            // 打印日志，方便观察程序执行结果，先打印客户端 ip 地址，再打印端口号，再打印请求和响应
            System.out.printf("\n客户端ip地址及端口号[%s; %d]\n请求：%s; 响应：%s\n", requestPacket.getAddress().toString(), requestPacket.getPort(),
                    request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
        udpEchoServer.start();
    }

    public String process(String request) {
        return request;
    }



    /*public void stack() throws IOException {
        System.out.println("服务器启动");// 添加日志
        while (true) {
            // 先拿到请求
            // 建立一个空的数据报装一下客户端的请求数据报
            DatagramPacket 客户端请求数据报 = new DatagramPacket(new byte[4096], 4096);
            socket.receive(客户端请求数据报);
            String 客户端请求 = new String(客户端请求数据报.getData(), 0, 客户端请求数据报.getLength());
            // 再做出反应
            String 结果 = process(客户端请求);
            // 最后返回响应
            // 先要包装成一个数据报
            DatagramPacket ret数据报 = new DatagramPacket(结果.getBytes(StandardCharsets.UTF_8), 结果.getBytes().length,
                    客户端请求数据报.getSocketAddress()// 客户端ip
                    );
            socket.send(ret数据报);
            // 打印日志，方便观察
            System.out.printf("客户端ip及端口号[%s; %d]\n请求：%s; 响应：%s", 客户端请求数据报.getAddress().toString(),
                    客户端请求数据报.getPort(),
                    客户端请求, 结果
                    );
        }
    }*/

}

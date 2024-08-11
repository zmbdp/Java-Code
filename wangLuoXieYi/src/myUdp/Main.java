package myUdp;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                UdpEchoServer udpEchoServer = new UdpEchoServer(9090);
                udpEchoServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1", 9090);
                udpEchoClient.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}

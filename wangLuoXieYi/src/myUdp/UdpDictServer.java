package myUdp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> map = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        map.put("cat", "小猫");
        map.put("dog", "修狗");
        map.put("fuck", "歪日");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request, "未查询到该单词!!!");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer = new UdpDictServer(9090);
        udpDictServer.start();
    }
}

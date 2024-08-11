package myTcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TcpDictServer extends TcpEchoServer{
    private Map<String, String> map = new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);
        map.put("cat\r\n", "小猫");
        map.put("dog\r\n", "修狗");
        map.put("fuck\r\n", "歪日");
    }
    @Override
    public String process(String request) {
        return map.getOrDefault(request, "未查询到该单词!!!");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}

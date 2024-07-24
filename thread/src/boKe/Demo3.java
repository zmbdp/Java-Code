package boKe;

public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello Thread");
                }
            }
        };
        t.start();

        while (true) {
            System.out.println("Hello Main");
        }
    }
}

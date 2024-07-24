package boKe;

public class Demo5 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Hello Thread");
            }
        });
        t.start();
        while (true) {
            System.out.println("Hello Main");
        }
    }
}

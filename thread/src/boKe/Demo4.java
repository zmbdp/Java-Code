package boKe;

public class Demo4 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello Runnable");
                }
            }
        });

        t.start();
        while (true) {
            System.out.println("Hello Main");
        }
    }
}

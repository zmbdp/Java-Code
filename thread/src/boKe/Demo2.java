package boKe;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello Runnable");
        }
    }
}

public class Demo2 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();
        while (true) {
            System.out.println("Hello Main1");
        }
    }
}

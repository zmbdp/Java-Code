package boKe;

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello Thread");
        }
    }
}

public class Demo1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        while (true) {
            System.out.println("Hello Main");
        }
    }
}

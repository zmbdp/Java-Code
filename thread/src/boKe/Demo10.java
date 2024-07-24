package boKe;

class Count {
    private int count = 0;

    public void addCount() {
        synchronized (Count.class) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class Demo10 {
    public static Count count = new Count();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count.addCount();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count.addCount();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count.getCount());
    }
}

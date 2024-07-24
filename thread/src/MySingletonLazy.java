
class SingletonLazy {
    volatile private static SingletonLazy singletonLazy = null;
    public static SingletonLazy getSingletonLazy() {
        if (singletonLazy != null) {
            return singletonLazy;
        }
        synchronized (SingletonLazy.class) {
            if (singletonLazy == null) {
                singletonLazy = new SingletonLazy();
            }
        }
        return singletonLazy;
    }
    private SingletonLazy() {};
}
public class MySingletonLazy {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            SingletonLazy singletonLazy = SingletonLazy.getSingletonLazy();
            System.out.println("1 结束");
        });
        thread.start();
        thread.join();
        System.out.println("2 结束");
    }
}

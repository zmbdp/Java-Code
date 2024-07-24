package myThread;
                                                 /* 单例模式 */
// 饿汉模式
class Singleton {
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 饿汉模式启动，只要把构造方法设置成私有的，别人就 new 不到这个对象了
    private Singleton() {}
}


// 懒汉模式
class SingletonLazy {
    private static Object locker = new Object();
    private static volatile SingletonLazy instance = null;
    public static int a = 0;

    public static SingletonLazy getInstance() {
        // 判断是不是第一次调用，是第一次调用的话往下走
        // 不是第一次调用就直接返回，因为加锁操作是开销很大的操作
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonLazy.class){
            if (instance == null) {
                instance = new SingletonLazy();
            }
        }
        return instance;
    }

    public static void add() {
        synchronized (locker) {
            a++;
        }
    }

    private SingletonLazy() {}
}


public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        //Singleton s3 = new Singleton();
        System.out.println(s1 == s2);

        SingletonLazy s3 = SingletonLazy.getInstance();
        SingletonLazy s4 = SingletonLazy.getInstance();
        System.out.println(s3 == s4);

        for (int j = 0; j < 500; j++) {
            Thread t1 = new Thread(() -> {
                SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
                int i = 0;
                while (i++ < 5000) {
                    singletonLazy1.add();
                }
            });
            Thread t2 = new Thread(() -> {
                SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
                int i = 0;
                while (i++ < 5000) {
                    singletonLazy2.add();
                }
            });

            t2.start();
            t1.start();
            t1.join();
            t2.join();
            Thread.sleep(500);
            System.out.println(SingletonLazy.a == (10000 + (j * 10000)));
        }
    }
}

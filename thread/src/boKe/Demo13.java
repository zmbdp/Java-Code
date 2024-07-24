package boKe;

// 懒汉模式
class SingletonLazy {
    volatile private static SingletonLazy instance = null;
    private SingletonLazy() {}
    private static Object locker = new Object();
    public static SingletonLazy getInstance() {
        // 判定是否是第一次
        if (instance != null) {
            return instance;
        }
        // 加锁保证赋值的时候一定是空的
        synchronized (locker){
            // 如果为空，就赋值
            if (instance == null) {
                instance = new SingletonLazy();
            }
        }
        return instance;
    }
}
public class Demo13 {
    volatile public static SingletonLazy s1 = null;
    volatile public static SingletonLazy s2 = null;
    public static void main(String[] args) {
        while (true){
            Thread t1 = new Thread(() -> {
                s1 = SingletonLazy.getInstance();
            });
            Thread t2 = new Thread(() -> {
                s2 = SingletonLazy.getInstance();
            });

            t1.start();
            t2.start();
            if (s1 != s2){
                System.out.println(s1 == s2);
            }
        }
    }
}

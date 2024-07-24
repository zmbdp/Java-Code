package myThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo17 {
    public static void main(String[] args) {
        // 创建出一个固定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(4);

        /*
        // 创建出一个线程数目动态变化的线程池
        ExecutorService service1 = Executors.newCachedThreadPool();

        // 包含单个线程（比原生的创建线程 API 更简单一些）
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        // 类似于定时器的效果，
        // 添加一些任务的时候，任务在后续的某个时刻再执行，
        // 被执行的之后可能是由多个线程共同执行所有任务
        ExecutorService service3 = Executors.newScheduledThreadPool();
        */
        for (int i = 0; i < 1000; i++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello");
                }
            });
        }

    }
}

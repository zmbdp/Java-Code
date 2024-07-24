package myThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo21 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int ret = 0;
                for (int i = 0; i < 5000; i++) {
                    ret++;
                }
                return ret;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t1 = new Thread(futureTask);

        t1.start();
        // 获取 call 方法的返回结果
        int ret = futureTask.get();
        System.out.println(ret);
    }
}

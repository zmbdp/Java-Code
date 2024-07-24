package myThread;

import java.util.Timer;
import java.util.TimerTask;

public class Demo15 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 定时器：这是个前台线程，并且可以执行多个任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第一个 timer 正在执行");
            }
        }, 3000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第二个 timer 正在执行");
            }
        },2000);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第三个 timer 正在执行");
            }
        },1000);
        System.out.println("Main 结束");
    }
}

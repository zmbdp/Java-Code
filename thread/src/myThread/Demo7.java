package myThread;

// 观察线程状态
//NEW: 安排了工作, 还未开始行动
//RUNNABLE: 可工作的. 又可以分成正在工作中和即将开始工作.
//BLOCKED: 这几个都表示排队等着其他事情
//WAITING: 这几个都表示排队等着其他事情
//TIMED_WAITING: 这几个都表示排队等着其他事情
//TERMINATED: 工作完成了.
public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //NEW: 安排了工作, 还未开始行动
        System.out.println(t.getState());
        //RUNNABLE: 可工作的. 又可以分成正在工作中和即将开始工作.
        t.start();
        System.out.println(t.getState());
        //BLOCKED: 这几个都表示排队等着其他事情

        //WAITING: 这几个都表示排队等着其他事情

        //TIMED_WAITING: 这几个都表示排队等着其他事情
        Thread.sleep(10);// 不等待的话有概率是 RUNNABLE ，因为可能 t 这个线程还没开始执行
        System.out.println(t.getState());
        //TERMINATED: 工作完成了.
        t.join();
        System.out.println(t.getState());


    }
}

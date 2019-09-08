package ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolSingleDemo {
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();//一池一个处理线程
        try {
            for (int i = 0; i <5 ; i++) {
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }

    }
}

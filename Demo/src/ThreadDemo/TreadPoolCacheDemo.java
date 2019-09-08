package ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TreadPoolCacheDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i <5; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                //try {TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) { e.printStackTrace();}
                //加上上面那句执行结果如下：
                //pool-1-thread-1	办理业务
                //pool-1-thread-1	办理业务
               //pool-1-thread-1	办理业务
                // pool-1-thread-1	办理业务
                //pool-1-thread-1	办理业务
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

package ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//java 中实现多线程的第四种方法
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //Array Arrays
        //Collection collections
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池五个处理线程

        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求业务
        try {
            for (int i = 0; i <10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

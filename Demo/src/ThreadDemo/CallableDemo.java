package ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class myCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"#########coming in call()");
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}


public class CallableDemo {
    public static void main(String[] args)throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(new myCallable());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new myCallable());
        new Thread(futureTask,"AAA").start();
        new Thread(futureTask,"BBB").start();//此处不会再调用call()方法。同样的操作复用而不是操作两次
        new Thread(futureTask1,"CCC").start();
        int result01 = 100;
        while(futureTask.isDone()){

        }
        int result02 = futureTask.get();
        System.out.println("*******result:"+(result01+result02));
    }
}

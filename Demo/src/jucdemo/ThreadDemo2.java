package jucdemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhongyiling
 * @date 2018/9/8 17:01
 * 主线程中需要执行比较耗时的操作时，可以把作业交给后台对象在后台完成
 * 当主线程需要时。就可以通过Future对象获得后台计算作业的执行结果或者状态
 */
class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("**************come in call()*******************");
        return 20;
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException,ExecutionException{
        /**
         * FutureTask(Callable<V> callable)
         * --Creates a FutureTask that will, upon running, execute the given Callable.
         * FutureTask(Runnable runnable, V result)
         * --Creates a FutureTask that will, upon running, execute the given Runnable,
         * and arrange that get will return the given result on successful completion.
        * */
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        FutureTask<Integer> futureTask1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("come in call for lambda");
                return 200;
            }
        });
        new Thread(futureTask,"AA").start();
        new Thread(futureTask1,"BB").start();
        System.out.println("call()方法的返回值："+futureTask.get());
        System.out.println("call()方法的返回值："+futureTask1.get());

    }
}

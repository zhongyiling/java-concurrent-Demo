package ThreadDemo;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
/*        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,
                8,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());*/
        //ThreadPoolExecutor
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

    }
}

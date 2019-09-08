package ProCumDome;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhongyiling
 * @date 2019/9/8 21:28
 */
class MyResource{
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    // 参数传入接口，程序扩展性好
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 日志信息尽量详细到具体类信息
        System.out.println(blockingQueue.getClass().getName());
    }

    public void productor() throws InterruptedException{
        String data = null;
        boolean reValue;
        while(flag){
            data = atomicInteger.incrementAndGet()+"";
            reValue = blockingQueue.offer(data,2l, TimeUnit.SECONDS);
            if (reValue){
                System.out.println("生产"+data+"成功");
            }else {
                System.out.println("生产"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("生产叫停");
    }
    public void customer() throws InterruptedException{
        String result = null;
        while(flag){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (null == result||result.equalsIgnoreCase("")){
                flag = false;
                System.out.println("超过两秒没有消费成功，消费退出");
                return;
            }
            System.out.println("消费"+result+"成功");
        }

    }
    public void stop(){
        this.flag = false;
    }
}
public class ProCusBlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产者线程启动");
                try {
                    myResource.productor();
                } catch (Exception e) {
                    e.printStackTrace();
                }

        },"productor").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"消费者线程启动");
            try {
                myResource.customer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"customer").start();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("时间到，生产消费行为停止");
        myResource.stop();
    }
}

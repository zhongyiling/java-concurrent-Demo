package LockDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ResourceData{
    private volatile boolean flag=true;//使用volatile保证数据可见性，书记修改立马被其他线程知道
    private AtomicInteger atomicInteger = new AtomicInteger();//代替产者消费者模式V2的number
    private BlockingQueue<String> blockingQueue=null;//不写具体的实现类，由用户传入的参数决定使用具体的实现类
    //blockingQueue的实现类由用户传入，根据依赖注入方式的。可以使用set注入与构造函数注入。此处使用构造函数注入
    public ResourceData(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());//相当于日志，此处信息要尽可能具体
    }
    public void myProd() throws Exception{
        String data = null;
        boolean reValue;
        while(flag){
            data = atomicInteger.incrementAndGet()+"";//
            reValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(reValue){
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"成功");
            }else{
                System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t叫停，生产结束");
    }
    public void myCustomer()throws Exception{
        //String data = null;
       String reValue;
        while(flag){
            //data = atomicInteger.incrementAndGet()+"";//
            reValue = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == reValue||reValue.equalsIgnoreCase("")){
                flag = false;
                System.out.println(Thread.currentThread().getName()+"\t超过两秒钟没有蛋糕，消费停止");
                return;//退出消费
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+reValue+"成功");
            //TimeUnit.SECONDS.sleep(2);
        }
    }
    public void stop(){
        this.flag = false;
    }
}
public class ProdConsumer_BlockQueue {
    public static void main(String[] args) {
        ResourceData resourceData = new ResourceData(new ArrayBlockingQueue<>(3));
        new Thread(()->{
            System.out.println("生产者线程启动");
            try {
                resourceData.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"AAA").start();
        //消费线程
        new Thread(()->{
            System.out.println("消费者线程启动");
            try {
                resourceData.myCustomer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BBB").start();
        System.out.println();
        System.out.println();
        System.out.println();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("时间到。生产消费线程停止");
        resourceData.stop();

    }
}

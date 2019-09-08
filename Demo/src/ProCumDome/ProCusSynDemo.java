package ProCumDome;

/**
 * @author zhongyiling
 * @date 2019/9/8 20:29
 *
 * 最传统的生产者消费者，模式
 *  synchronized、wait和notify
 */
class Resource{
    private int number = 0;
    public synchronized void increment() throws Exception{
        //判断
        while(number != 0){
            //等待，不能生产
            wait();
        }
        // 生产
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 通知唤醒
        notify();
    }
    public synchronized void desrement() throws Exception{
        while(number == 0){
            // 等待，不能生产
            wait();
        }
        // 生产
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 通知唤醒
        notify();
    }
}
public class ProCusSynDemo {
    public static void main(String[] args) {
        Resource resource = new Resource();
        //生产线程
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    resource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"productor").start();
        //消费线程
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    resource.desrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"customer").start();
    }
}

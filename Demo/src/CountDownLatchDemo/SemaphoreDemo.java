package CountDownLatchDemo;
//Semaphore信号灯类，
//秒杀场景中应用
//停车场车位争抢
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//三个停车位
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();//抢占车位
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("停车三秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();//释放车位
                }
            },String.valueOf(i)).start();

        }
    }
}

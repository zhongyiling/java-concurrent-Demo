package CountDownLatchDemo;
//this Demo shows us how to use the CountDownLatch
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(6);
        CountDownLatch countDownqin = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
                countDown.countDown();
            },String.valueOf(i)).start();
        }
        countDown.await();
        System.out.println(Thread.currentThread().getName()+"\t班长锁门，离开教室");
        for (int j = 1; j <=6 ; j++) {//若j从零开始则会报错nullPointException
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t国，灭亡");
                countDownqin.countDown();
            },CountryEnum.forEach_CountryEnum(j).getRetMessage()).start();
        }
        countDownqin.await();
        System.out.println(Thread.currentThread().getName()+"\t秦灭六国，一统华夏");
    }
}
//如果不使用CountDownLatch，可能的结果为：
//2	上完自习，离开教室
//main	班长锁门，离开教室
//3	上完自习，离开教室
//1	上完自习，离开教室
//5	上完自习，离开教室
//0	上完自习，离开教室
//4	上完自习，离开教室

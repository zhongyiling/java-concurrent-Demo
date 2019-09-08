package ProCumDome;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{//资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception{
        lock.lock();
        // 判断
        try {
            while(number != 0){
                // 等待，不能生产
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void desrement() throws Exception{
        lock.lock();
        // 判断
        try {
            while(number == 0){
                // 等待，不能消费
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            // 通知唤醒
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
//
//线程        操作      资源类(高内聚，低耦合)
//判断        干活      通知
//防止虚假唤醒机制
//一个初始值为零的变量，两个线程对其操作，一个加一，一个减一，来5轮
public class ProCusDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        //生产线程
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"AAA").start();
        //消费线程
        new Thread(()->{
            for (int i = 1; i <=5 ; i++) {
                try {
                    shareData.desrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BBB").start();
    }
    //生产线程
}

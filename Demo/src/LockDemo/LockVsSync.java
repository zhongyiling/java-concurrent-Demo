package LockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class ShareResourece{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try {
            //判断
            while(number!=1){
                c1.await();
            }
            //干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 2;
            c2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            //判断
            while(number!=2){
                c2.await();
            }
            //干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 3;
            c3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            //判断
            while(number!=3){
                c3.await();
            }
            //干活
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            number = 1;
            c1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockVsSync {
    public static void main(String[] args) {
        ShareResourece shareResourece = new ShareResourece();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResourece.print5();
            }
        },"AAA").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResourece.print10();
            }
        },"BBB").start();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                shareResourece.print15();
            }
        },"CCC").start();
    }

}

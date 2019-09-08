package LockDemo;
import kotlin.jvm.Synchronized;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Phone implements Runnable{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\tinvoked sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail()throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t#########invoked sendEmail()");
    }
        Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try {
            System.out.println("this is in get"+Thread.currentThread().getName());
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println("this is in set"+Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }
}
public class LockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            }catch(Exception e){
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            }catch(Exception e){
                e.printStackTrace();
            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("#######this is ReentrantLock######");
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

        //t3.run();


    }
}
//运行结果
//          14	invoked sendSMS()
//        14	invoked sendEmail()
//        15	invoked sendSMS()
//        15	invoked sendEmail()

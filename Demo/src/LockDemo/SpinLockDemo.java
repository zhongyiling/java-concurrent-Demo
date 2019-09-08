package LockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
//利用云子引用的CAS写一个自旋锁
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();
    public void myLock()
    {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in......");
        while(!atomicReference.compareAndSet(null,thread))
        {
           // System.out.println("I have got the lock");
        }
    }
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"unlock");
    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);

            }catch(InterruptedException e){
                e.printStackTrace();
            }finally {
                spinLockDemo.unLock();
            }
        },"t1").start();
        try { TimeUnit.SECONDS.sleep(5); }catch(InterruptedException e){ e.printStackTrace();}
        new Thread(()->{
            spinLockDemo.myLock();
            spinLockDemo.unLock();
        },"t2").start();



    }
}

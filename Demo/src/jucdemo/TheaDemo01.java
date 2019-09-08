package jucdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*java JUC API学习练习
* 题目：三个售票员卖出30票，用线程模拟
*1.线程       操作      资源类
* 2.高内聚     低耦合
*
* */
class Ticket{
    private int number = 30;
    private Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();  // block until condition holds
        try {
            if ( number >0 ){
                System.out.println(Thread.currentThread().getName()+"\t卖出第"+(30-(--number))+"\t还剩下"+number); // ... method body
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}
public class TheaDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
//        工程代码中，接口尽量使用内部匿名类来实现。
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40 ; i++) {
                    ticket.sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40 ; i++) {
                    ticket.sale();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <40 ; i++) {
                    ticket.sale();
                }
            }
        }, "C").start();
//        暂停主线程三秒。保证上面的线程A,B，C执行完。
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("============================lamda表达式写法===================================");
//        lamda表达式写法
        Ticket ticket1 = new Ticket();
        new Thread(() -> {for (int i = 1; i <40 ; i++) { ticket1.sale(); }},"AA").start();
        new Thread(() -> {for (int i = 1; i <40 ; i++) { ticket1.sale(); }},"BB").start();
        new Thread(() -> {for (int i = 1; i <40 ; i++) { ticket1.sale(); }},"CC").start();
        /*
        * lamda表达式写法使得程序更加简洁明了
        * */
    }
}

package VolatileDemo;

import java.util.concurrent.TimeUnit;
//volatile可见性验证
class MyData{
    volatile int number = 0;
    //int number = 0;
    public void addTo60(){
        this.number = 60;
    }
}
/*
1.验证volatile可见性
        假设int number = 0，number变量无volatile修饰
 */
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData=new MyData();
        new Thread(() -> {
            System.out.print(Thread.currentThread().getName()+"\t come in"+"\n");
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.print(Thread.currentThread().getName()+"\t update number:"+myData.number+"\n");
        },"AAA").start();
        while(myData.number == 0){
            //System.out.print(Thread.currentThread().getName()+"\t main():"+myData.number+"\n");
            //number不加volatile。此处加上如上代码，也能保证可见性，因为print中的会将线程工作空间的值刷回主内存
            //println(),
        }
        System.out.print(Thread.currentThread().getName()+"\t main():"+myData.number+"\n");
}
}

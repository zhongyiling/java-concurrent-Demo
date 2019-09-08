package CAS;

/*CAS：====》compareAndSet
  比较并交换
        */

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\tcurrent data:"+atomicInteger.get());
        //atomicInteger.compareAndSet(5,2019)-->如果线程的期望值与主物理内存的真实值一样，则返回TRUE并修改线程值为新值
        // 将工作内存的值5改为2019并写回主内存，并通知其他线程可见
        System.out.println(atomicInteger.compareAndSet(5,2018)+"\tcurrent data:"+atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}

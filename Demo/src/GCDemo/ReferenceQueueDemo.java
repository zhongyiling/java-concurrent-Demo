package GCDemo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
//次demo演示引用队列在GC前后的值
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException{
        Object o1 =   new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("==============================");
        o1 = null;
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
    }
}

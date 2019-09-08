package GCDemo;

import java.lang.ref.SoftReference;


public class SoftReferenceDemo {
    public static void softReference_Enough(){
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        System.out.println(obj1);
        System.out.println(softReference.get());
        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(softReference.get());
    }
    public static void main(String[] args) {
        softReference_Enough();
    }
}

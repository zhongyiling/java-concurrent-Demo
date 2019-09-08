package GCDemo;
//此Demo演示强引用不会被垃圾回收

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;//此时obj2为一个强引用
        //obj1 = null;
        System.gc();
        System.out.println(obj2);
        System.out.println(obj2);
    }
}

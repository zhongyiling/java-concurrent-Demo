package GCDemo;

/*虚拟机栈(栈桢中的局部变量区，也叫局部变量表)中引用的对象
方法区中的类静态属性引用的对象
方法区中常量引用的对象
本地方法栈中引用的对象(例如线程中start方法引用的对象)
* */
class GCRoot2{

}
class GCRoot3{

}
public class GCRootDemo {
    private static GCRoot2 t2;//方法区中的类静态属性引用的对象
    private static final GCRoot3 t3 = new GCRoot3();//方法区中常量引用的对象
    public static void m1(){
        GCRootDemo t1 = new GCRootDemo();//t1:虚拟机栈(栈桢中的局部变量区，也叫局部变量表)中引用的对象
        System.gc();
        System.out.println("第一次GC完成");
    }
    public static void main(String[] args) {
        m1();
    }
}

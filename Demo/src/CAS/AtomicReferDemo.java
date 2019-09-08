package CAS;

//原子引用
import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class AtomicReferDemo {
    public static void main(String[] args) {
        //AtomicInteger atomicInteger = new AtomicInteger();
        User zhangsan = new User("zhangsan",22);
        User lisi = new User("lisi",33);
        AtomicReference<User> atomicReference = new AtomicReference();
        atomicReference.set(zhangsan);
        System.out.println(atomicReference.compareAndSet(zhangsan,lisi)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(zhangsan,lisi)+"\t"+atomicReference.get().toString());

    }
}

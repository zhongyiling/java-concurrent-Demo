package ArrayListDemo;
//集合类线程不安全
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArrayListUnsafeDemo {
    public static void main(String[] args) {
        //ArrayList<Integer> arrayList = new ArrayList<Integer>();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //ConcurrentModificationException并发修改异常

    }
}

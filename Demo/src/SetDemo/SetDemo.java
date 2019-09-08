package SetDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SetDemo {
    public static void main(String[] args) {
        //ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i <300; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        //ConcurrentModificationException并发修改异常
    }

}

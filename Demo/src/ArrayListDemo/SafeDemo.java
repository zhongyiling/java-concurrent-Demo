package ArrayListDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
/*

1.故障现象
java.util.ConcurrentModificationException
2.导致原因

3.解决方案
    3.1 new Vector()
    3.2 Collections.synchronizedList(new ArrayList<>());
    3.3new CopyOnWriteArrayList()
*/

public class SafeDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <300; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}

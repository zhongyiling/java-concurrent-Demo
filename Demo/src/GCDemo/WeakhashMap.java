package GCDemo;

import java.util.HashMap;
import java.util.WeakHashMap;
//这个demo演示WeakHashhMap经过gc后就会被回收
//WeakHashhMap适用于做高速缓存
public class WeakhashMap {
    public static void main(String[] args) {
        System.out.println("My hashMap");
        myHashmap();
        System.out.println("======================");
        myWeakHashMap();
    }
    public static  void myHashmap(){
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key,value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t"+map.size());
    }
    public static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "weakhashmap";
        map.put(key,value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map+"\t"+map.size());
    }
}

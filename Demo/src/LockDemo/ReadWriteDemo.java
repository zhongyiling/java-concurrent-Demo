package LockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读共享
//写不共享
class Mycache{
    private volatile Map<String,Object> map = new HashMap<String,Object>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();//如果不适用读写锁，会出现写入不独占的情况
    public void put(String key,Object value){
        rwlock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"正在写入"+key);
            try{ TimeUnit.MILLISECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入完成");}
        catch(Exception e){e.printStackTrace();}
        finally {
            rwlock.writeLock().unlock();
        }
    }
    public void get(String key){
        rwlock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"正在读取"+key);
            try{ TimeUnit.MILLISECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完成");
        }catch(Exception e){e.printStackTrace();}
        finally {
            rwlock.readLock().unlock();
        }

    }

}
public class ReadWriteDemo {
    public static void main(String[] args) {
        Mycache myCache = new Mycache();
        for (int i = 0; i <5 ; i++) {
            final int itemp = i;
            new Thread(()->{
                myCache.put(itemp+"",itemp+"");
                //myCache.put(i+"",i+"");
            },String.valueOf(i)).start();
        }
        try{TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println("#######################################################");
        for (int i = 0; i <5 ; i++) {
            final int itemp = i;
            new Thread(()->{
                myCache.get(itemp+"");
            },String.valueOf(i)).start();
        }

    }
}

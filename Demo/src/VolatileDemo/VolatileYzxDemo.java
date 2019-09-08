package VolatileDemo;

import VolatileDemo.TestData;

//import java.util.concurrent.TimeUnit;
public class VolatileYzxDemo {
    public static void main(String[] args) {
        TestData testData = new TestData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    testData.addPlusPlus();
                    testData.atomicAdd();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.print(Thread.currentThread().getName()+"\t number:"+testData.number+"\n");
        System.out.print(Thread.currentThread().getName()+"\t atomicInteger:"+testData.atomicInteger+"\n");
    }
}

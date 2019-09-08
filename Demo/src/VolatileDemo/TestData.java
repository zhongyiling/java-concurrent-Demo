package VolatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class TestData {
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
    public void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    //原子加1
    public void atomicAdd(){
        atomicInteger.getAndIncrement();
    }
}

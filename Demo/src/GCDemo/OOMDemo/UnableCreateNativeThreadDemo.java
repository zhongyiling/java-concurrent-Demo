package GCDemo.OOMDemo;
//此Demo演示unable  to create native thread error
//需要在linux系统上演示

/**
 * javac -d . UnableCreateNativeThreadDemo.java
 * java GCDemo.OOMDemo.UnableCreateNativeThreadDemo
 */
public class UnableCreateNativeThreadDemo {
    public static void main(String[] args) {
        for (int i = 0;  ; i++) {
            new Thread(()->{
                try { Thread.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }
            },""+i).start();

        }
    }
}

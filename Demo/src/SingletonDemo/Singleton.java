package SingletonDemo;

public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance() throws InterruptedException {
        synchronized (Singleton.class) {
            if (instance == null) {
                Thread.sleep(100);
                instance = new Singleton();
            }
            return instance;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <2 ; i++) {
            new Thread(()->{
                try {
                    Singleton e = Singleton.getInstance();

                    System.out.println("线程"+Thread.currentThread().getName()+"实例为"+e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },i+"").start();
        }
    }
}

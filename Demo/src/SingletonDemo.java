public class SingletonDemo {
    private static SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"我是构造方法");
    }
/*    public static  SingletonDemo getInstance(){
        if (instance == null){
            instance = new SingletonDemo();
        }
        return instance;

    }*/
//double check locked 双端检索机制
    //DCL机制可能会因为指令重排无法保证单例模式
    public static synchronized SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //单线程单例模式
/*        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        System.out.println("多线程");*/
        for(int i=0;i<10;i++){
            new Thread(() -> {
                SingletonDemo.getInstance();//不加synchronize，执行构造方法六次
            },String.valueOf(i)).start();

        }
    }

}

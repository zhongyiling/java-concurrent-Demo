package SingletonDemo;
public class SingletonStatic {
    private static SingletonStatic INSTANCE = null;
    static{
        if (null == INSTANCE) {
            INSTANCE = new SingletonStatic();
        }
    }
    private SingletonStatic(){}
    public static SingletonStatic getInstance(){
        return INSTANCE;
    }
    public static void main(String[] args) {
        SingletonStatic singleton1 = SingletonStatic.getInstance();
        SingletonStatic singleton2 = SingletonStatic.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}
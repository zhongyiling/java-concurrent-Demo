package SingletonDemo;

public enum SingletonEnum {
    INSTANCE;
    // 构造器需要私有化，因而用private修饰
    private SingletonEnum(){
        System.out.println("this is construct");
    }
}

package SingletonDemo;

public class SingletonTest {
    public static void main(String[] args) {
        // 获取两个实例
        System.out.println(SingletonHurgy.INSTANCE.toString());
        SingletonHurgy singleton1 = SingletonHurgy.getInstance();
        SingletonHurgy singleton2 = SingletonHurgy.getInstance();
        // 比较两个实例的地址是否相等，若相等则为同一个实例
/*        System.out.println(singleton1 == singleton2);
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        SingletonStatic singleton1 = SingletonStatic.getInstance();
        SingletonStatic singleton2 = SingletonStatic.getInstance();*/
        System.out.println(singleton1 == singleton2);


    }
}

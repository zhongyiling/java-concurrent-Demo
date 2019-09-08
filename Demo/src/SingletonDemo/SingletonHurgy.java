package SingletonDemo;
/**
 * 1.构造器私有化
 * 2.自行创建并且用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是一个单例我们可用final修饰,表示不可修改
 */

public class SingletonHurgy {
    public static final SingletonHurgy INSTANCE = new SingletonHurgy();
    private SingletonHurgy(){
    }
    public static SingletonHurgy getInstance(){
        return INSTANCE;
    }
}

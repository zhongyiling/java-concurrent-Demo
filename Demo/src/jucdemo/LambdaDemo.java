package jucdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
interface MyFoo{
    //public void print();
    public int add(int x,int y);
    // 接口中default方法个数不受限制
    default int dev(int x,int y){
        return x/y;
    }
    default int mod(int x,int y){
        return x%y;
    }
    public static void sayHello(){
        System.out.println("*******************hello java****************");
    }
}
/**
 * 1.函数式编程
 * 2.Lambda表达式公式：（形参列表） -> {方法体实现}
 * 3.@FunctionalInterface标识该接口是函数式接口，当接口只有一个方法时。默认为函数式接口
 * 4.default方法的默认实现。打破了接口只定义不能实现的旧规则
* */
public class LambdaDemo {
    public static void main(String[] args) {
//        直接new 接口，接口相当于一种类，可以直接new
/*        MyFoo myFoo = new MyFoo(){
            // 需要实现接口的方法
            @Override
            public void print() {
                System.out.println("hello world!");
            }

            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };
        myFoo.print();*/
//        Lambda表达式(只适用于函数式接口)
        MyFoo myFoo = (x,y) -> {return x + y;};
        System.out.println("add方法的执行结果"+myFoo.add(3,3));
        System.out.println("dev方法的执行结果"+myFoo.dev(10,5));
        MyFoo.sayHello();
//      增强型for循环在java8中的写法
        // 以前的写法如下：
/*        List<Integer> list = Arrays.asList(11,22,33,44,55);
        for ( Integer element  :list) {
            System.out.println(element);
        }*/
//      java8中的简洁写法
        Arrays.asList(11,22,33,44,55).forEach(System.out::println);
    }
}

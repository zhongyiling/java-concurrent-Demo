package GCDemo.OOMDemo;

/**
 * 演示java.lang.StackOverflowError
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }
    public static void stackOverflowError(){
        stackOverflowError();
    }
}

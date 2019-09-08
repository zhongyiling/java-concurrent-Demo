package GCDemo;

public class MemoryDemo {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("totalMemory:"+totalMemory/(double)1024/1024+"M");
        System.out.println("maxMemory:"+maxMemory/(double)1024/1024+"M");
    }
}

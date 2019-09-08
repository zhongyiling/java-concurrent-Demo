package GCDemo.OOMDemo;

/**演示java.lang.OutOfMemoryError: Java heap space
 * JVM配置：-Xms10m -Xmx10m
 *
 */
public class JavaHeapSpaceErroeDemo {
    public static void main(String[] args) {
        byte[] bytes = new byte[20*1024*1024];
    }
}

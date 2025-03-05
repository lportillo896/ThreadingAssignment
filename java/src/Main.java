import java.lang.Runnable;
import java.lang.Thread;

public class Main implements Runnable {
    private String threadName;

    public Main(String name){
        this.threadName = name;
    }

    public static void main(String[] args) {
        Thread[] ta = new Thread[10];
        for (int i = 0; i < 10; i++) {
            ta[i] = new Thread(new Main("THREAD_" + i));
        }
        for (int i = 0; i < 10; i++) {
            ta[i].start();
        }
    }

    @Override
    public void run() {
        LazyInitializedSingleton lis = LazyInitializedSingleton.getInstance();
        System.out.printf("Hello World from %s: Code: %d%n", this.threadName, lis.hashCode());
    }
}

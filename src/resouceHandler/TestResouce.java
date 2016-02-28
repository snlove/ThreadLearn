package resouceHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by acer on 2016/2/28.
 */
public class TestResouce {

    public static void main(String args[]) {
        test(new LockEventGenetor());
    }

    public static void test(IntGenetor genetor,int count) {
        ExecutorService serv = Executors.newCachedThreadPool();
        for (int i=0; i< count; i++) {
            serv.execute(new EventChecker(genetor,i));
        }
        serv.shutdown();
    }

    public static void test(IntGenetor genetor) {
        test(genetor,2);
    }
}

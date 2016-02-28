package learn.excepCatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by acer on 2016/2/28.
 */
public class CaptureUncaughtException {

    public static void main(String args[]) {
        ExecutorService service = Executors.newCachedThreadPool(new MyThreadFactory());
        service.execute(new ExceptionThreadTwo());
       // service.shutdown();
    }
}

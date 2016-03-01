package thridOperate.operate.CustomQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/29.
 */
public class TosterMatic {

    public static void main(String args[]) {
        ToasterQueue dryQue = new ToasterQueue();
        ToasterQueue butQue = new ToasterQueue();
        ToasterQueue jamQue = new ToasterQueue();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new TosterMachine(dryQue));
        service.execute(new ToaterButter(dryQue,butQue));
        service.execute(new ToaterJam(butQue,jamQue));
        service.execute(new ToasetEater(jamQue));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
    }
}

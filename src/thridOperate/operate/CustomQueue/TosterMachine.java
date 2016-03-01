package thridOperate.operate.CustomQueue;

import Util.PrintUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**生产Toaster的机器
 * Created by acer on 2016/2/29.
 */
public class TosterMachine implements Runnable {

    private ToasterQueue toasterQueue;
    private int count;
    private Random random = new Random(47);

    public TosterMachine(ToasterQueue toasterQueue) {
        this.toasterQueue = toasterQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toster toster = new Toster(count++);
                PrintUtil.priintall(toster);
                toasterQueue.put(toster);
            } catch (InterruptedException e) {
                PrintUtil.priintall("the ToaserMachine is interrupted");
                return;
            }

        }
        PrintUtil.priintall("Product the machine is done");

    }
}

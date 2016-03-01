package thridOperate.operate.customModel;

import Util.PrintUtil;

/**消费者
 * Created by acer on 2016/2/29.
 */
public class Customer implements Runnable {

    private Resutant r;

    public Customer(Resutant r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    if (r.meal == null) {
                        wait();
                    }
                }
                PrintUtil.priintall("the custom order " + r.meal + "\n");
                synchronized (r.chef) {
                    r.meal = null;
                    r.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            PrintUtil.priintall("the thread interrupted  \n");
        }
    }
}

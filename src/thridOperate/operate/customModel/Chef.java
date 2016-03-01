package thridOperate.operate.customModel;

import Util.PrintUtil;

import java.util.concurrent.TimeUnit;

/**生产者
 * Created by acer on 2016/2/29.
 */
public class Chef implements Runnable{

    private Resutant r;
    private int count;

    public Chef(Resutant r) {
        this.r = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    if (r.meal != null) {
                        wait();
                    }
                    if (++count == 10) {  //饭店生产的最大产品数
                        PrintUtil.priintall("the orgin is used up \n");
                        r.exec.shutdownNow();
                    }
                }

                PrintUtil.priintall("the meal is order up \n");
                synchronized (r.customer) {
                    r.meal = new Meal(count);
                    r.customer.notifyAll();
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            PrintUtil.priintall("the thread interrupted  \n");
        }
    }
}

package thridOperate.operate.CustomQueue;

import Util.PrintUtil;

/**jam to Toaser
 * Created by acer on 2016/2/29.
 */
public class ToaterJam implements Runnable {

    private ToasterQueue buttleQueue;
    private ToasterQueue jamQueue;

    public ToaterJam(ToasterQueue buttleQueue, ToasterQueue jamQueue) {
        this.buttleQueue = buttleQueue;
        this.jamQueue = jamQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toster toster = buttleQueue.take();
                toster.jam();
                PrintUtil.priintall(toster);
                jamQueue.put(toster);
            } catch (InterruptedException e) {
                PrintUtil.priintall("the jam is interrupted");
                return;
            }

        }
        PrintUtil.priintall("the jam is done");
    }
}

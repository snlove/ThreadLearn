package thridOperate.operate.CustomQueue;

import Util.PrintUtil;

/**
 * Created by acer on 2016/2/29.
 */
public class ToaterButter implements Runnable{

    private ToasterQueue dryQueue;
    private ToasterQueue buttleQueue;

    public ToaterButter(ToasterQueue dryQueue, ToasterQueue buttleQueue) {
        this.dryQueue = dryQueue;
        this.buttleQueue = buttleQueue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toster t = dryQueue.take();
                t.buttle();
                PrintUtil.priintall(t);
                buttleQueue.put(t);
            } catch (InterruptedException e) {
                PrintUtil.priintall("The ButtleToaser is interrupted");
                return;
            }
        }
        PrintUtil.priintall("the Buttle is done");
    }
}

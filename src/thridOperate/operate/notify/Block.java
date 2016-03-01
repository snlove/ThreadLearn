package thridOperate.operate.notify;

import Util.PrintUtil;

/**
 * 演示notifyall并非唤醒所有的线程
 * Created by acer on 2016/2/29.
 */
public class Block {


    public Block() {


    }

    public synchronized void waittingCall() {
        try {
            while (Thread.interrupted()) {
                wait();
                PrintUtil.printb(Thread.currentThread() + " \n");
            }
        } catch (InterruptedException e) {
            PrintUtil.printb("the thread is interrupted");
            return;
        }

    }

    public synchronized void singal() {
        notify();
    }

    public synchronized void singalALL() {
        notifyAll();
    }

}

package learn;

import Util.PrintUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/28.
 */
public class Sleeper extends Thread {

    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            PrintUtil.printb(getName() + "  was Interruperd   " + "    isInterruper   " + isInterrupted());
            return;
        }

        PrintUtil.printb(getName() + " has awaker");
    }
}

package learn;

import Util.PrintUtil;

import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/28.
 */
public class Joiner extends Thread {

private  Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
           // TimeUnit.MILLISECONDS.sleep(100);
            PrintUtil.printb(getName()+ "  join complied");
           // sleeper.join(100);
        } catch (InterruptedException e) {

            PrintUtil.printb(getName() + "    was Interruperd    " + "   isInterruper     " + isInterrupted());
        }

    }
}

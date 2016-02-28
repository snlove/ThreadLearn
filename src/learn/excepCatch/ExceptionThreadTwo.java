package learn.excepCatch;

import Util.PrintUtil;

/**
 * Created by acer on 2016/2/28.
 */
public class ExceptionThreadTwo implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        PrintUtil.printb("run by : " + t);
        PrintUtil.printb("exceptionHandler : " + t.getUncaughtExceptionHandler());
        throw new RuntimeException("the exception will be catched");
    }
}

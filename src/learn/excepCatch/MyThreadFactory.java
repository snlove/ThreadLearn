package learn.excepCatch;

import Util.PrintUtil;

import java.util.concurrent.ThreadFactory;

/**
 * Created by acer on 2016/2/28.
 */
public class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        PrintUtil.printb(this + "is createing the new Thread");
        Thread thread = new Thread(r);
        PrintUtil.printb("created Thread is :" + thread);
        thread.setUncaughtExceptionHandler(new MyCatchExceptionHandler());
        PrintUtil.printb("threadException Handler is  :" + thread.getUncaughtExceptionHandler());
        return thread;
    }
}

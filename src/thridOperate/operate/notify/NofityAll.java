package thridOperate.operate.notify;

import Util.PrintUtil;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/29.
 */
public class NofityAll {


    public static void main(String args[]) {
        ExecutorService  service = Executors.newCachedThreadPool();
        Task task1 = new Task();
        Task2 task2 = new Task2();
        for(int i=0; i< 5; i++) {
            service.execute(task1);
            service.execute(task2);
        }
        Timer timer = new Timer();
        //对任务一进行唤醒
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean pro = true;
            @Override
            public void run() {
                if (pro) {
                    PrintUtil.printb("notify   " + Task.class + "\n");
                    Task.block.singal();
                    pro = false;
                } else {
                    PrintUtil.printb("   notifyall     " + Task.class + "\n");
                    Task.block.singalALL();
                    pro = true;
                }
            }
        }, 400,400);
        try {
            TimeUnit.SECONDS.sleep(5);
            timer.cancel();
            PrintUtil.printb("Time cancel\n");
            TimeUnit.SECONDS.sleep(5);
            PrintUtil.printb("notifyall   " + Task2.class + "\n");
            Task2.block.singalALL();
            TimeUnit.SECONDS.sleep(5);
            PrintUtil.printb("shut down\n");
            service.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

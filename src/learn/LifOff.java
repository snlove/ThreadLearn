package learn;

import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/27.
 */
public class LifOff implements Runnable {

//    定义相关的变量
    protected  int countdown = 10;  //default
    private static  int takeCount  = 0;
    private  final int id = takeCount++;

    public LifOff() {

    }


    public LifOff(int countdown) {
        this.countdown = countdown;
    }


    @Override
    public void run() {
        while (countdown-- > 0) {
            System.out.print(status());
            Thread.yield();
            //显示的休眠线程
           // TimeUnit.MINUTES.sleep(time);
        }
    }

    private String status() {
        return "#" + id + "(" +  (countdown > 0 ? countdown : "liftoff") + "),";
    }
}

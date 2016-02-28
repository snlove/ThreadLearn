package learn;

import Util.PrintUtil;

/**
 * Created by acer on 2016/2/28.
 */
public class SimplePriorty implements  Runnable{

    private int countdown = 5;
    private volatile  double d;
    private  int proioty;

    @Override
    public String toString() {
        return Thread.currentThread() + "," + countdown;
    }

    public SimplePriorty(int proioty) {
        this.proioty = proioty;
    }

    @Override
    public void run() {
//        在此设置即可，在构造器重直接设置优先级没有太大价值，因为还没有执行
        Thread.currentThread().setPriority(proioty);
        while (true) {
            for (int i=0; i<100000; i++) {
                d += (Math.PI + Math.E ) / (double)i;  //具体的复杂操作，增加执行时间，使得线程调度可以实现
                if (i % 1000 == 0) {
                    Thread.yield();
                }
                PrintUtil.printb(this);  //调用的toString方法
            }

            if (--countdown == 0) {
                return;
            }
        }
    }
}

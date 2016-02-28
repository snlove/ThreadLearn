package learn;

import Util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by acer on 2016/2/27.
 */
public class Main {

    public static void main(String args[]) {


//        //第二种
       // pruductThreada();

//        第三中，也是推荐的方法
        //goodThreadb();



//          线程返回值
       // resultThread();


//        测试优先级
        //proiortyThread();


//        后台线程
        //deamonThread();

//        加入
        //joinShow();


        //异常演示证明无法捕获
        //noCatchExp();

    }

    private static void noCatchExp() {
        try {
            ExecutorService excepSer = Executors.newCachedThreadPool();
            excepSer.execute(new ExceptionThread());
            excepSer.shutdown();
        } catch (RuntimeException e) {
            PrintUtil.printb(e.getLocalizedMessage());
        }
    }

    private static void joinShow() {
        Sleeper
                sleepy = new Sleeper("Sleep",1500),
                grom = new Sleeper("grom",1500);
        Joiner
                dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("doc",grom);

        grom.interrupt();
    }

    private static void deamonThread() {
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    PrintUtil.printb("HOUTAI");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tt.setDaemon(true);  //start前调用
        tt.start();
        PrintUtil.printb(" all deamon is start");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void proiortyThread() {
        ExecutorService service2 = Executors.newCachedThreadPool();
        for (int i  =0; i<5; i++) {
            service2.execute(new SimplePriorty(Thread.MIN_PRIORITY));
            service2.execute(new SimplePriorty(Thread.MAX_PRIORITY));
        }
        service2.shutdown();
    }

    private static void resultThread() {
        ExecutorService valueSer = Executors.newCachedThreadPool();
        //存储返回的结果
        List<Future<String>> result = new ArrayList<Future<String>>();
        for(int j=0; j<5; j++) {
            //返回必须使用此方法,返回的值封装在Future中
            result.add(valueSer.submit(new TaskWithResult(j)));
        }

        for (Future<String> fs: result) {
            try {
                PrintUtil.printa(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                valueSer.shutdown();
            }
        }
    }

    private static void goodThreadb() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i  =0; i<5; i++) {
            service.execute(new LifOff());
        }
        service.shutdown();

        ExecutorService service1 = Executors.newSingleThreadExecutor();
        for (int i  =0; i<5; i++) {
            service1.execute(new LifOff());
        }
        service.shutdown();
    }

    private static void pruductThreada() {
        Thread tt = new Thread(new LifOff());
        tt.start();
        PrintUtil.printa("wait for lifoff");
    }

}

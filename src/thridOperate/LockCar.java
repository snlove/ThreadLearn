package thridOperate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用lock和Conditon来进行任务的锁定，singlall比notify更安全
 * Created by acer on 2016/2/29.
 */
public class LockCar {

    private boolean chckeon = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 冲水操作
     *
     * @author sn
     * @date 2016/2/29  11:15
     */
    public void wateron() {
        try {
            lock.lock();
            chckeon = true; //wait for dry
            //PrintUtil.printb("Car is watering");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 擦水操作
     *
     * @author sn
     * @date 2016/2/29  11:17
     */
    public void drycar() {
        try {
            lock.lock();
            if (chckeon) {
                TimeUnit.MILLISECONDS.sleep(5);  //模拟具体的过程
                chckeon = false;
                condition.signalAll();
            }
            //PrintUtil.printb("Car is drying");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    /**
     * 等待冲水
     *
     * @author sn
     * @date 2016/2/29  11:17
     */
    public void waitforWater() {
        try {
            lock.lock();
            while (!chckeon) {
                condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        //PrintUtil.printb("wari for watering the car");
    }

    /**
     * 等待擦水
     *
     * @author sn
     * @date 2016/2/29  11:17
     */
    public  void watiforDry() {
        try {
            lock.lock();
        while (chckeon) {
               condition.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        //PrintUtil.printb("the car is wait for drying");
    }

}

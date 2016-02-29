package thridOperate;

import Util.PrintUtil;

import java.util.concurrent.TimeUnit;

/**一个汽车封装类，模拟汽车的某个操作，前后具有依赖关系
 * Created by acer on 2016/2/29.
 */
public class Car {

    private boolean chckeon = false;

    /**
     * 冲水操作
     *
     * @author sn
     * @date 2016/2/29  11:15
     */
    public synchronized void wateron() {
        chckeon = true; //wait for dry
        //PrintUtil.printb("Car is watering");
        notifyAll();
    }

    /**
    * 擦水操作
    * @author sn
    * @date 2016/2/29  11:17
    */
    public synchronized void drycar() {
        if (chckeon) {
            try {
                TimeUnit.MILLISECONDS.sleep(5);  //模拟具体的过程
                //PrintUtil.printb("Car is drying");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chckeon = false;
            notifyAll();
        }
    }

    /**
     * 等待冲水
     *
     * @author sn
     * @date 2016/2/29  11:17
     */
    public synchronized void waitforWater() {
        while (!chckeon) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //PrintUtil.printb("wari for watering the car");
    }

    /**
     * 等待擦水
     *
     * @author sn
     * @date 2016/2/29  11:17
     */
    public synchronized void watiforDry() {
        while (chckeon) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //PrintUtil.printb("the car is wait for drying");
    }


}

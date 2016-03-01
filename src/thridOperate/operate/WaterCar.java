package thridOperate.operate;

import Util.PrintUtil;
import thridOperate.operate.Car;

import java.util.concurrent.TimeUnit;

/**对汽车进行冲水
 * Created by acer on 2016/2/29.
 */
public class WaterCar implements Runnable {

    private Car car;

    public WaterCar(Car car) {
        this.car = car;
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            car.wateron();
            car.watiforDry();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                PrintUtil.priintall("Water is finish \n");
            } catch (InterruptedException e) {
                PrintUtil.priintall("Exit via interrupt \n");
                return;
            }
        }
        PrintUtil.priintall("Task is end");
    }
}

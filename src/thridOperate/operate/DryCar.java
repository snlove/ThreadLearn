package thridOperate.operate;

import Util.PrintUtil;
import thridOperate.operate.Car;

import java.util.concurrent.TimeUnit;

/**对汽车进行干燥操作
 * Created by acer on 2016/2/29.
 */
public class DryCar  implements Runnable {

    private Car car;

    public DryCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

            try {
                car.drycar();
                car.waitforWater();
                TimeUnit.MILLISECONDS.sleep(100);
                PrintUtil.priintall("dry is finish \n");
            } catch (InterruptedException e) {
                PrintUtil.priintall("Exit via interrupt \n");
                return;
            }
        }
        PrintUtil.priintall("Task of end");

    }
}

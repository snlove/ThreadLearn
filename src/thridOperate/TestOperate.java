package thridOperate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/29.
 */
public class TestOperate {

    public static void main(String args[]) throws InterruptedException {
        Car c = new Car();
        ExecutorService service = Executors.newCachedThreadPool();
        WaterCar waterCar = new WaterCar(c);
        DryCar dryCar = new DryCar(c);
        service.execute(waterCar);
        service.execute(dryCar);
        TimeUnit.SECONDS.sleep(5);
        service.shutdown();


    }
}

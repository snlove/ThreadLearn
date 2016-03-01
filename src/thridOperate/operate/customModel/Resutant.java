package thridOperate.operate.customModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**生产和消费的场所
 * Created by acer on 2016/2/29.
 */
public class Resutant {
    public Meal meal;
    public static  Chef chef;
    public static Customer customer;
    public static ExecutorService exec;

    public Resutant() {
        exec = Executors.newCachedThreadPool();
        customer = new Customer(this);
        chef = new Chef(this);

    }

    public static void main(String args[]) {
        new Resutant();
        exec.execute(chef);
        exec.execute(customer);
    }
}

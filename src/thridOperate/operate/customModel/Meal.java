package thridOperate.operate.customModel;

/**消费的物品
 * Created by acer on 2016/2/29.
 */
public class Meal {
    private int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal : " + orderNum + "\n";
    }
}

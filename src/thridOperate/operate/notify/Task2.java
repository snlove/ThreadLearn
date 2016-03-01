package thridOperate.operate.notify;

/**持有某个锁的第二个任务
 *
 * Created by acer on 2016/2/29.
 */
public class Task2 implements Runnable {

    static Block block = new Block();



    @Override
    public void run() {
         block.waittingCall();
    }
}

package thridOperate.operate.notify;

/**持有锁的第一个任务
 * Created by acer on 2016/2/29.
 */
public class Task implements Runnable {

    static Block block = new Block();



    @Override
    public void run() {
            block.waittingCall();
    }
}

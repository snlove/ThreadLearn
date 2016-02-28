package learn;

/**捕捉异常演示类
 * Created by acer on 2016/2/28.
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

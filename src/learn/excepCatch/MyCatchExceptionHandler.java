package learn.excepCatch;

import Util.PrintUtil;

/**自己定义的异常处理工具类
 * Created by acer on 2016/2/28.
 */
public class MyCatchExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        PrintUtil.priintall("catch :"+ e);
    }
}

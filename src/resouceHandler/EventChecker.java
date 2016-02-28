package resouceHandler;

import Util.PrintUtil;

/**
 * Created by acer on 2016/2/28.
 */
public class EventChecker implements Runnable {

    private IntGenetor intGenetor;
    private final  int id;

    public EventChecker(IntGenetor intGenetor, int id) {
        this.intGenetor = intGenetor;
        this.id = id;
    }

    @Override
    public void run() {
        while (!intGenetor.isCancel()) {
            int value = intGenetor.next();
            //如果不存在资源冲突，检测器就不会打印相关语句，一直都是偶数
            if (value % 2 != 0) {
                PrintUtil.printb(value + " not even");
                intGenetor.cancel();
            }
        }
    }
}

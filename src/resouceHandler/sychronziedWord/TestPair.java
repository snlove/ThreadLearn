package resouceHandler.sychronziedWord;

import Util.PrintUtil;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by acer on 2016/2/29.
 */
public class TestPair {

    public static void main(String args[]) {
        PairManager pm1 = new PairManager1();
        PairManager pm2 = new PairManager2();
        test(pm1, pm2);
    }


    /**
     * 测试具体执行方法
     *
     * @author sn
     * @date 2016/2/29  9:39
     */

    private static void test(PairManager pm1, PairManager pm2) {
        ExecutorService service = Executors.newCachedThreadPool();
        PairManipulator
                manipulator1 = new PairManipulator(pm1),
                manipulator2 = new PairManipulator(pm2);
        PairChecker
                chcke1 = new PairChecker(pm1),
                check2 = new PairChecker(pm2);
        service.execute(manipulator1);
        service.execute(manipulator2);
        service.execute(chcke1);
        service.execute(check2);
        service.shutdown();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            PrintUtil.priintall("the sleep is interrupted");
        }

        PrintUtil.printb("Pm1 :" + pm1 + "\n" + "pm2 : " + pm2);
        System.exit(0);
    }
}

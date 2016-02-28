package resouceHandler;

import Util.PrintUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**关键字synchronized同步方法的演示
 * Created by acer on 2016/2/28.
 */
public class SerialNumberChecker {


    /**
     * 内部列，实现数据的添加和检测操作
     *
     * @author sn
     * @date 2016/2/28  20:14
     */
    static class CircleSet {
        /**
        * use sychronized data must be private ,
        */
        private int[] array;
        private int size;
        private int index = 0;

        public CircleSet(int size) {
            this.size = size;
            array = new int[size];

//            给数组赋初值
            for (int i=0; i<size ; i++) {
                array[i] = -1;
            }
        }

        private synchronized void add(int i) {
            array[index] = i;

            //序列增加
            index = ++index % size;
        }

        private synchronized boolean contans(int i) {
            for (int j = 0; j < size; j++) {
                if (array[j] == i) {
                    return true;
                }
            }
            return  false;
        }
    }

    /**
    * the runnale to check if has conflict
    * @author sn
    * @date 2016/2/28  20:27
    */

    static class SerialThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                int val = SerialNumberGenetor.nextSerialeNumber();
                if (set.contans(val)) {
                    PrintUtil.printb("Depilcate : " + val);
                    System.exit(0);
                }
                set.add(val);
            }
        }
    }

    /**
    * define some use bianliang
    */
    private static  final  int MAX_SIZE = 10;
    private static ExecutorService servce;
    private static CircleSet set = new CircleSet(1000);

    public static void main(String args[]) {
        servce = Executors.newCachedThreadPool();
        for (int j = 0; j< MAX_SIZE;j++) {
            servce.execute(new SerialThread());
        }
        servce.shutdown();
    }

}

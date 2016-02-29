package resouceHandler.sychronziedWord;

/**进行Pari数据的多线程操作的具体实现
 * Created by acer on 2016/2/28.
 */
public class PairManipulator implements Runnable {

    private PairManager pairManager;

    public PairManipulator(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.inscerment();
        }
    }


}

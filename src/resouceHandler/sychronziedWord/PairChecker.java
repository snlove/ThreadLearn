package resouceHandler.sychronziedWord;

/**
 * Created by acer on 2016/2/29.
 */
public class PairChecker implements Runnable {

    private PairManager pairManager;

    public PairChecker(PairManager pairManager) {
        this.pairManager = pairManager;
    }

    @Override
    public void run() {
        while (true) {
            pairManager.checkCounter.incrementAndGet();
            pairManager.getPair().checkState();
        }
    }
}

package resouceHandler.sychronziedWord;

import java.util.List;

/**
 * 具体实现类，通过同步方法实现线程安全递增
 * Created by acer on 2016/2/29.
 */
public class PairManager1 extends PairManager {


    private Pair pair;

    @Override
    public synchronized void inscerment() {
        pair = getRealPari();
        pair.incrementX();
        pair.incrementY();
        storge(pair);
    }
}

package resouceHandler.sychronziedWord;

import java.util.List;

/**
 * Created by acer on 2016/2/29.
 */
public class PairManager2 extends PairManager {


    private Pair pair;


    @Override
    public void inscerment() {
        synchronized (this) {
            pair = getRealPari();
            pair.incrementY();
            pair.incrementX();
        }
        storge(pair);
    }
}

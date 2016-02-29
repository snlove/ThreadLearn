package resouceHandler.sychronziedWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**对pair里的数据进行处理的抽象模板类
 * Created by acer on 2016/2/28.
 */
public abstract class PairManager {

     /**
     * 线程安全的list
     */
    private List<Pair> store = Collections.synchronizedList(new ArrayList<Pair>());
    private final Pair pari = new Pair();
    AtomicInteger checkCounter = new AtomicInteger();

    public synchronized Pair getPair() {
//        为了保护pair，直接返回一个新的
        return new Pair(pari.getX(),pari.getY());
    }

    public synchronized Pair getRealPari() {
        return pari;
    }

    public void storge(Pair pair) {
        if (pair != null) {
            store.add(pair);
        }
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加方法
     */
    public abstract void inscerment();

    @Override
    public String toString() {
        return "Pair :" + getPair() + "   CheckCounter  " + checkCounter;
    }
}


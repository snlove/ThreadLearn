package resouceHandler;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by acer on 2016/2/28.
 */
public class LockEventGenetor extends IntGenetor {
    private int countValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
        lock.lock();
        try{
            ++countValue;
            Thread.yield();
            ++countValue;
            return countValue;
        } finally {
            lock.unlock();
        }

    }
}

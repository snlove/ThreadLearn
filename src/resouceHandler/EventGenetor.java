package resouceHandler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**整数检测器的具体是西安
 * Created by acer on 2016/2/28.
 */
public class EventGenetor extends IntGenetor {
    private int currentValut = 0;
    private int count = 5;
    //演示冲突问题方法
//    @Override
//    public int next() {
//
////        如果不存在资源冲突，检测器就不会打印相关语句，一直都是偶数
//            ++currentValut;
//            ++currentValut;
//            return currentValut;
//
//    }


//    使用锁
    @Override
    public synchronized int next() {

//        如果不存在资源冲突，检测器就不会打印相关语句，一直都是偶数
        ++currentValut;
        ++currentValut;
        return currentValut;

    }
}

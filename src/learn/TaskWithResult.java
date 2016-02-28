package learn;

import java.util.concurrent.Callable;

/**
 * Created by acer on 2016/2/28.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of the taskwithreuslt :" + id + "\n";
    }
}

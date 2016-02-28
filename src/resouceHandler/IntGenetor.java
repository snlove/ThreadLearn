package resouceHandler;

/**
 * Created by acer on 2016/2/28.
 */
public abstract class IntGenetor {

    private volatile boolean cancel = false;

    public abstract int next();
    public void cancel () {
        cancel = true;
    }

    public boolean isCancel() {
        return  cancel;
    }
}

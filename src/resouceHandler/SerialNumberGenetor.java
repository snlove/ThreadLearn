package resouceHandler;

/**
 * Created by acer on 2016/2/28.
 */
public class SerialNumberGenetor  {
    private static volatile int seraileNumber = 0;

    public static int nextSerialeNumber() {
        return ++seraileNumber;
    }
}

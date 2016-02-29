package resouceHandler.sychronziedWord;

/**
 * 数据封装类
 *
 * @author sn
 * @date 2016/2/28  22:07
 */
public class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "x :" + x + "  " + "y : " + y;
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }

/**
* 异常类  
* @author sn
* @date 2016/2/28  22:20
*/
    class PairValueNotEqualException extends RuntimeException {

        public PairValueNotEqualException() {
            super("Pari valus not equal " + Pair.this);
        }
    }


}






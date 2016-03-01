package thridOperate.operate.CustomQueue;

import Util.PrintUtil;

/**
 * Created by acer on 2016/2/29.
 */
public class ToasetEater implements Runnable{

    private ToasterQueue easterQue;
    private int count = 0;

    public ToasetEater(ToasterQueue easerQue) {
        this.easterQue = easerQue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Toster t = easterQue.take();
                if (t.getId() != count++ || t.getStatus() != Toster.Status.JAM) {
                    PrintUtil.priintall("error the toaste is not match the condition");
                    System.exit(1);
                } else {
                    PrintUtil.priintall(" chom " + t);
                }
            } catch (InterruptedException e) {
                PrintUtil.priintall("the eater is interrupted");
                return;
            }
        }
        PrintUtil.priintall("the easter is done");
    }
}

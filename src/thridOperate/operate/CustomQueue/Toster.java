package thridOperate.operate.CustomQueue;

import com.sun.xml.internal.ws.message.jaxb.JAXBMessage;

/**x信息封装类，封装Toster的不同状态
 * Created by acer on 2016/2/29.
 */
public class Toster {

    /**
    * 定义三中状态
    */
    public enum Status {
        DRY, BUTTLE, JAM  }

    private Status  status = Status.DRY;
    private final int id;

    public Toster(int id) {
        this.id = id;
    }

    public void buttle() {
        status = Status.BUTTLE;
    }

    public void jam() {
        status = Status.JAM;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toaster " + id + "   status ：  " + status;
    }
}

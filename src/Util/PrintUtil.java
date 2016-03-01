package Util;

import learn.SimplePriorty;

/**
 * Created by acer on 2016/2/27.
 */
public class PrintUtil {

    public static void printa(String strig) {
        System.out.print(strig);
    }

    public static void printb(String s) {
        System.out.println(s);
    }

    public static void printb(SimplePriorty simplePriorty) {
        System.out.println(simplePriorty);
    }

    public static void priintc(Throwable e) {
        System.out.print(e);
    }
    public static void priintall(Object e) {
        System.out.println(e);
    }
}

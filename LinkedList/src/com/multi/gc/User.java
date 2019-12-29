package com.multi.gc;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/26 11:43
 * @description:
 */
public class User {

    public static User user;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("----------------------------------");
        System.out.println("finalize() --> start");
        user = this;
        System.out.println("this = " + this);
        System.out.println("finalize() --> end");
        System.out.println("----------------------------------");

    }
}

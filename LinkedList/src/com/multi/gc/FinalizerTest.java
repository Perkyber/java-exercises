package com.multi.gc;


/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/26 11:46
 * @description:
 */
public class FinalizerTest {

    /**
     * finalize()最多只调用一次的特性，可以延长对象的生命周期
     *
     * @param args 入参
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.println("初始化user = " + user);
        user = null;
        System.gc();
        // 主线程休眠1s，优先执行垃圾回收器
        System.out.println("开始主线程休眠");
        Thread.sleep(1000);
        System.out.println("线程休眠1s结束");

        user = User.user;
        System.out.println("重新赋值后user = " + user);
        System.out.println(user != null);

        // 第二次并没有调用finalize
        user = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(user != null);
    }
}

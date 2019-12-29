package com.multi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Integer是包装类（引用类），通过"=="实际上是比较内存地址
 * 在jdk1.5以后的版本引入IntegerCache，对-128~high数值进行缓存，用于提升性能和节省内存
 * 其中low指定为-128，high默认为127（可通过配置文件设置，但不能超过Integer.MAX_VALUE边界）
 */
public class IntegerTest {
    /**
     * 123在-128~127之间，第一次装箱后自动缓存到内存区
     * 128不在-128~127之间，故不会缓存到内存区
     * 对i2和i4装箱各有区别，i2会从缓存区取数（取得是对应的内存地址），i3则重新开辟新的内存空间
     */
    public static void main(String[] args) {
        Integer i1 = 123;
        Integer i2 = 123;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false
        System.out.println(i1.equals(i2)); // true
        System.out.println(i3.equals(i4)); // true
    }

    private class User{
        private String name;
        private Integer age;
    }
}

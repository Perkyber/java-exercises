package com.multi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/25 16:02
 * @description:
 */
public class ListTest02 {

    /**
     * debug查看ArrayList按原长度1.5倍扩展
     * 10 -> 15
     */
    @Test
    public void arrayListIncrement() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < 11; i++) {
            list.add(i);
        }
    }

    @Test
    public void arrayListIncrement01() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            // 自动装箱操作
            list.add(i, i);
        }
    }

    /**
     * debug查看Vector按原长度2倍扩展
     * 10 -> 20
     */
    @Test
    public void vectorIncrement() {
        Vector<Integer> vector = new Vector<>(10);
        for (Integer i = 0; i < 11; i++) {
            vector.add(i);
        }
    }
}

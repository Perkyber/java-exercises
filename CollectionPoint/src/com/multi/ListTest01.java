package com.multi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/23 15:21
 * @description:
 */
public class ListTest01 {

    /**
     * {@code forEachRemaining}顾名思义处理<tt>迭代<tt/>剩余的元素
     * 接收{@param Consumer}
     * 循环处理完剩余元素，当前空间就无任何元素
     * 再次进行处理当为空
     * 理解：集合迭代过程中相当于做一次<tt>流操作<tt/>
     */
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        System.out.println("只取第一个元素：");
        System.out.println(iterator.next());
        System.out.println("forEachRemaining处理剩余元素：");
        iterator.forEachRemaining(System.out::println);
        System.out.println("再用forEachRemaining处理下：");
        iterator.forEachRemaining(System.out::println);
    }
}

package com.multi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/22 21:19
 * @description: java练习
 */
public class ListTest {

    /**
     * 描述：打印a，b后抛出{@code ConcurrentModificationException}
     * 原因：
     * 在迭代的过程中对集合中'c'元素进行了删除，
     * 在checkForComodification检测中{@code modCount != expectedModCount}成立，
     * 抛出ConcurrentModificationException异常
     */
    @Test
    public void errorOperate01() {
        operate('c');
    }

    /**
     * 描述：貌似能正确打印元素而不报错
     * 原因：
     * {@param size} 当前集合大小
     * {@param cursor} 当前游标指向next
     * {@code cursor != size} 条件判断，当条件不成立说明遍历到<i>tail</i>位置
     * 删除'd'元素后，size->4，cursor->4
     * {@code hasNext()}返回false，错误认为迭代结束，反而没有异常退出
     * 总结：显然这种退出是不健康的，一是漏打印'e'，二是虽然没报错但不能自己骗自己
     */
    @Test
    public void errorOperate02() {
        operate('d');
    }

    /**
     * 在给集合迭代的时候，会进行<tt>int expectedModCount = modCount</tt>初始化操作
     * {@code modCount}是集合修改次数记录值，集合每修改一次就会加1
     * 在对集合迭代过程中，都会调用checkForComodification()方法
     * 检测当前集合是否发生了修改，以确保线程安全
     * 当然这种情况主要还是针对线程不安全的集合，例如{@link java.util.ArrayList}
     * 使用{@link java.util.concurrent.CopyOnWriteArrayList}变体代替{@code ArrayList}
     * 因为{@code CopyOnWriteArrayList}是线程安全的，能并行进行操作
     *
     * @param ch 需要操作的元素
     */
    private void operate(Character ch) {
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');
        Iterator<Character> iterator = list.iterator();
        while (iterator.hasNext()) {
            Character character = iterator.next();
            if (character.equals(ch)) {
                list.remove(ch);
            } else {
                System.out.println("character = " + character);
            }
        }
    }

    /**
     * 使用CopyOnWriteArrayList
     */
    @Test
    public void successOperate03() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("c")) {
                list.remove("c");
            }
            System.out.println("s = " + s);
        }
        System.out.println("list=" + list);
    }
}
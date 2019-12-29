package com.multi.linked;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/26 9:33
 * @description:
 */
public class Node {
    Integer data;
    Node next;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    protected void finalize() throws Throwable {
        // 是否调用此方法
        System.out.println("Node --> finalize()");
    }
}

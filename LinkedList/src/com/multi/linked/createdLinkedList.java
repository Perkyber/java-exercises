package com.multi.linked;

import java.util.Objects;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/26 9:40
 * @description:
 */
public class createdLinkedList {

    /**
     * 初始化头
     * 注意：若没有初始化头，一定要加判断，免得空指针
     */
    private static Node head = new Node();

    /**
     * 新增节点
     *
     * @param val 元素
     */
    private static void addData(int val) {
        // 初始化节点，完成装箱
        Node nextNode = new Node(val);
        // 临时节点
        Node temp = head;

        // 循环寻找到链尾
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nextNode;
    }

    /**
     * 遍历链表
     *
     * @param head 头节点
     */
    private static void traverse(Node head) {
        Node temp = head;

        // 循环遍历
        while (temp != null) {
            if (temp.data != null) {
                System.out.print(temp.data + " ");
            }
            temp = temp.next;
        }
    }

    /**
     * 插入
     *
     * @param head  头节点
     * @param index 索引下标[0~length-1]
     * @param value 插入元素
     */
    private static void insert(Node head, int index, int value) {
        if (index < 0 || index > getLength(head) - 1) {
            throw new IndexOutOfBoundsException("索引下标越界");
        }

        Node temp = head;
        Node insertNode = new Node(value);
        int cursor = 0;
        while (temp.next != null) {
            if (index == cursor) {
                insertNode.next = temp.next;
                temp.next = insertNode;
                // 插入退出
                return;
            }

            cursor++;
            temp = temp.next;
        }
    }

    /**
     * 删除节点
     *
     * @param head  头节点
     * @param index 索引下标[0~length-1]
     */
    private static void delete(Node head, int index) {
        if (index < 0 || index > getLength(head) - 1) {
            throw new IndexOutOfBoundsException("索引下标越界");
        }

        Node temp = head;
        int cursor = 0;
        while (temp.next != null) {
            if (index == cursor) {
                Node deleteNode = temp.next;
                temp.next = deleteNode.next;
                // 立即销毁节点
                deleteNode = null;
                System.gc();
                try {
                    /*
                     * 休眠主程序，立即执行销毁(垃圾回收器是低优先级运行)
                     * 慎用，这里只是为了整齐输出，阻塞主程序不是个好建议
                     *
                     * 垃圾回收器的特点是标记失效资源，并不会主动销毁资源
                     * 一定时间段会扫描一次，可能程序结束资源都得不到释放
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 删除退出
                return;
            }

            cursor++;
            temp = temp.next;
        }
    }

    /**
     * 获取链表长度
     *
     * @param head 头节点
     * @return length 链表长度
     */
    private static int getLength(Node head) {

        // 初始化长度
        int length = 0;

        Node temp = head.next;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // 获取长度
        return length;
    }

    /**
     * 对链表进行冒泡排序
     * 时间复杂度：Ф(n^2)
     * 排序过程：(最坏情景)
     * [head] -> 5 -> 4 -> 3 -> 2 -> 1|^
     * **********↓**************↓ (指针右移次数3)
     * [head] -> 4 -> 3 -> 2 -> 1 -> 5|^ 第一趟 比较4次
     * **********↓*********↓      (指针右移次数2)
     * [head] -> 3 -> 2 -> 1 -> 4 -> 5|^ 第二趟 比较3次
     * **********↓****↓           (指针右移次数1)
     * [head] -> 2 -> 1 -> 3 -> 4 -> 5|^ 第三趟 比较2次
     * **********↓                (指针右移次数0)
     * [head] -> 1 -> 2 -> 3 -> 4 -> 5|^ 第四趟 比较1次
     *
     * @param head 头节点
     */
    private static void BubbleSort(Node head) {
        int length = getLength(head);
        Node nextNode = head.next;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nextNode.data > nextNode.next.data) {
                    int tempData = nextNode.data;
                    nextNode.data = nextNode.next.data;
                    nextNode.next.data = tempData;
                }
                // 每比较一次指针后移
                nextNode = nextNode.next;
            }
            // 每比较一趟重置nextNode回首节点
            nextNode = head.next;
        }
    }

    /**
     * 指定寻找倒数第{@code K}个节点
     * 方法：设置两个指针p1和p2，p1始终比p1快K-1个距离(多走K个节点)
     * 当指针p1指向链尾时，p2就正处于K位置
     * <p>找倒数第2个节点</p>
     * <p>
     * ********************↓(target)
     * [head] -> 1 -> 3 -> 5 -> 4|^
     * *****↓(pos)****↓(per)
     * [head] -> 1 -> 3 -> 5 -> 4|^
     * **********↓(pos)****↓(per)
     * [head] -> 1 -> 3 -> 5 -> 4|^
     * ***************↓(pos)****↓(per)
     * [head] -> 1 -> 3 -> 5 -> 4|^
     * ********************↓(pos)****↓(per)
     * [head] -> 1 -> 3 -> 5 -> 4|^
     *
     * @param head 头节点
     * @param K    倒数第{@code K}个节点
     * @return 返回指定位置节点
     */
    private static Node designatedNode(Node head, int K) {
        if (K < 1 || K > getLength(head))
            throw new IndexOutOfBoundsException("位置边界溢出");
        // 先行指针
        Node previous = head;
        // 定位指针
        Node position = head;
        for (int i = 0; i < K; i++) {
            previous = previous.next;
        }

        while (previous != null) {
            previous = previous.next;
            position = position.next;
        }
        return position;
    }

    /**
     * 删除重复数据
     * 算法描述：
     * 定义两个指针，初始状态参照指针指向头节点，
     * 定位指针指向头节点下一节点。
     * 第一趟，移动定位指针，其指向每个节点与头节点比较，若有相同则删除；
     * 若没发现相同节点，移动直至position = null结束这一趟
     * 第二趟，移动参照指针指向下一节点，将position置为reference.next，
     * 重复上一步骤
     * .
     * .
     * .
     * 第n趟，参照指针指向最后节点，结束整个删除过程
     * <p>
     * **********↓****↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * **********↓*********↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * **********↓**************↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * **********↓*******************↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * ***************↓****↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * ***************↓*********↓
     * [head] -> 3 -> 6 -> 7 -> 6 -> 6|^
     * ***************↓*********↓
     * [head] -> 3 -> 6 -> 7 -> 6|^
     * ***************↓****↓
     * [head] -> 3 -> 6 -> 7|^
     * ********************↓
     * [head] -> 3 -> 6 -> 7|^
     *
     * @param head 头节点
     */
    private static void deleteDuplicate(Node head) {
        // 参照节点(这个节点数据是否重复)
        Node reference = head.next;
        // 定位重复数据节点
        Node position = reference.next;

        while (reference != null) {
            while (position != null) {
                if (reference.data.equals(position.data)) {
                    Objects.requireNonNull(getPerNode(head, position)).next = position.next;
                }
                position = position.next;
            }

            // 下一趟，从target.next开始
            reference = reference.next;
            // 控制position不为空
            if (reference != null) {
                position = reference.next;
            }
        }
    }

    /**
     * 查找上一节点
     *
     * @param head     头节点
     * @param nextNode 下一节点
     * @return perNode
     */
    private static Node getPerNode(Node head, Node nextNode) {
        if (nextNode == null && head == null)
            throw new NullPointerException("空指针异常");
        if (head == nextNode)
            return null;
        Node perNode = head;
        while (perNode.next != nextNode) {
            perNode = perNode.next;
        }
        return perNode;
    }

    // 诚然此方法在此场景(默认头节点不存任何数据)中存在问题

//    /**
//     * 实现链表的反转
//     *
//     * [head] -> 1 -> 2 -> 3 -> 4
//     * 4 -> 3 -> 2 -> [head] (×)
//     *
//     * @param head 链表的头节点
//     */
//    private static Node reverseLinkList(Node head) {
//
//        Node pre = null;
//        Node next;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }

    public static void main(String[] args) {
        // 存储元素
        addData(6);
        addData(7);
        addData(3);
        addData(4);
        addData(2);
        addData(3);
        addData(1);
        addData(3);
        addData(3);
        addData(8);
        addData(8);
        // 遍历链表
        System.out.print("添加遍历：");
        traverse(head);

        System.out.print("\r\n向index为5的位置插入8：");
        // 插入元素
        insert(head, 5, 8);
        traverse(head);

        System.out.print("\r\n-----------------------------");
        System.out.println("\r\n删除索引为3的节点：");
        // 删除节点
        delete(head, 3);
        traverse(head);
        System.out.print("\r\n-----------------------------");

        System.out.print("\r\n按从小到大排序：");
        // 冒泡排序
        BubbleSort(head);
        traverse(head);

        System.out.print("\r\n倒数第2个节点数据为：");
        // 找到倒数第K个节点
        System.out.println(designatedNode(head, 2).data);

        System.out.print("删除重复数据：");
        // 删除重复数据
        deleteDuplicate(head);
        traverse(head);

        /*System.out.print("\r\n反转数据：");
        Node node = reverseLinkList(head);
        traverse(node);

        System.out.println(getPerNode(head, head) == null);*/
    }
}

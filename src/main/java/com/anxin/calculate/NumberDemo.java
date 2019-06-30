/*
 * Copyright (C) 2018 anxin All rights reserved.
 *
 * Created by shouax on 2019/4/25 19:08.
 */

package com.anxin.calculate;

import com.anxin.bean.ListNode;
import org.junit.Test;

/**
 * 〈数字相关〉.
 *
 * @author: shouanxin
 * @date: 2019/4/25
 */
public class NumberDemo {
    @Test
    public void testAddTwoNumber() {
        ListNode l1 = new ListNode(6);
        l1.setNext(new ListNode(7));
        l1.getNext().setNext(new ListNode(8));
        ListNode l2 = new ListNode(9);
        l2.setNext(new ListNode(4));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
        System.out.println(876 + 49);
    }

    /**
     * 功能描述: 〈两数之和〉.
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1 加数
     * @param l2  加数
     * @return  ListNode
     * @author shouanxin
     * @date  2019/4/25 19:24
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int next = 0;
        while (p != null || q != null) {
            int a = p != null ? p.getValue() : 0;
            int b = q != null ? q.getValue() : 0;
            int pre = cur.getValue();
            int sum = a + b + pre;
            next = sum / 10;
            cur.setValue(sum % 10);
            cur.setNext(new ListNode(next));
            cur = cur.getNext();
            if (p != null) {
                p = p.getNext();
            }
            if (q != null) {
                q = q.getNext();
            }
        }

        return result;
    }
}

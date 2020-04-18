package com.alex.leetcode.demo.easy;

import javax.xml.soap.Node;

/**
 * 链表翻转
 *
 * @author shenjiangang
 * @date 2020/04/18
 */
public class ReverseList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 遍历
     *
     * @param head
     *
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 定义目标链表
        ListNode result = null;

        // 遍历链表
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = result;
            result = node;
            head = head.next;
        }
        return result;
    }

    public ListNode result = null;

    /**
     * 递归头结点
     *
     * @param head
     *
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return result;
        }
        ListNode newHead = head.next;
        head.next = result;
        result = head;
        // 递归遍历头结点
        return reverseList(newHead);
    }
}

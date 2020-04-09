package com.alex.leetcode.demo.model;

import lombok.ToString;

/**
 * 链表 两数相加
 *
 * @author shenjiangang
 * @date 2020/04/09
 */
@ToString
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

package com.alex.leetcode.demo.medium;

import lombok.ToString;

import java.util.Stack;

/**
 * 两数相加
 *
 * @author shenjiangang
 * @date 2020/04/14
 */
public class AddTwoNumbersPro {
    @ToString
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 利用栈的先进后出原则实现加法
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 将链表数据入栈，栈顶为低位
        while ((l1 != null) || (l2 != null)) {
            if (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }
        }

        int num1 = 0;
        int num2 = 0;

        // 存储进位数据
        int carry = 0;

        // 最终结果
        ListNode result = null;

        // 出栈，出栈过程是计算相对低位数据的过程
        while (!stack1.empty() || !stack2.empty() || carry == 1) {
            num1 = stack1.empty() ? 0 : stack1.pop();
            num2 = stack2.empty() ? 0 : stack2.pop();
            ListNode listNode = new ListNode(0);

            // 有进位的情况
            if (num1 + num2 + carry > 9) {
                listNode.val = num1 + num2 + carry - 10;
                carry = 1;
            } else {
                // 无进位
                listNode.val = num1 + num2 + carry;
                carry = 0;
            }

            // 原有高位降一位
            listNode.next = result;
            // 设置最新高位
            result = listNode;
        }

        return result;
    }

    public static void main(String[] args) {
        //[7,2,4,3][5,6,4]
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));

    }
}

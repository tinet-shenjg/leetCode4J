package com.alex.leetcode.demo.medium;

import com.alex.leetcode.demo.model.ListNode;

/**
 * 两数相加
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author shenjiangang
 * @date 2020/04/09
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers test = new AddTwoNumbers();
        System.out.println(test.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int a, b;

        // 存储进位数据
        int carry = 0;

        ListNode resultNode = new ListNode(0);

        // 当前节点
        ListNode currNode = resultNode;
        int sum = 0;

        // 遍历链表
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                a = 0;
            } else {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                b = 0;
            } else {
                b = l2.val;
                l2 = l2.next;
            }

            ListNode nextNode;
            sum = a + b + carry;
            if (sum > 9) {
                nextNode = new ListNode(sum - 10);
                carry = 1;
            } else {
                nextNode = new ListNode(sum);
                carry = 0;
            }

            // 保存next节点，切换当前节点
            currNode.next = nextNode;
            currNode = nextNode;

        }

        // 最高位有进位
        if (carry == 1) {
            ListNode node = new ListNode(1);
            currNode.next = node;
        }

        // 去除头部假节点
        return resultNode.next;

    }

}

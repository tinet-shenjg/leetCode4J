package com.alex.leetcode.demo.medium;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author shenjiangang
 * @date 2020/04/12
 */
public class SumNumbers {
    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        return getLeafSum(root, 0);
    }

    /**
     * 计算当前节点的子节点路径之和
     *
     * @param node 当前节点
     * @param sum 总数
     *
     * @return
     */
    public static int getLeafSum(TreeNode node, int sum) {
        // 节点为空时直接返回
        if (node == null) {
            return 0;
        }

        // 深度每下行一次 计算最新总数
        sum = sum * 10 + node.val;

        // 节点遍历完成条件（即叶子节点）
        if (node.left == null && node.right == null) {
            return sum;
        }

        // 递归遍历所有子节点
        return getLeafSum(node.left, sum) + getLeafSum(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(sumNumbers(root));
    }


}

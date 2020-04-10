package com.alex.leetcode.demo.medium;

/**
 * 最大面积
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * @author shenjiangang
 * @date 2020/04/10
 */
public class MaxArea {

    /**
     * 计算最大容量
     *
     * @param height n 个非负整数集合
     *
     * @return 最大容量
     */
    public static int maxArea(int[] height) {
        // 定义最大容量
        int maxArea = 0;

        // 采用双指针来计算最大容量
        int left = 0;
        int right = height.length - 1;

        // 指针第一次相遇为终结点
        while (left < right) {
            // 计算当前的最大容量
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            // 移动指针，相对短的木板向另一侧一定
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public static int maxArea2(int[] height) {
        int maxarea = 0;
        for (int m = 0; m < height.length; m++) {
            for (int n = m + 1; n < height.length; n++) {
                maxarea = Math.max(maxarea, Math.min(height[m], height[n]) * (n - m));
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        System.out.println(maxArea2(height));
    }
}

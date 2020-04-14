package com.alex.leetcode.demo.medium;

import java.util.PriorityQueue;

/**
 * 第k大元素
 *
 * @author shenjiangang
 * @date 2020/04/13
 */
public class KNumber {
    /**
     * 最小堆获取数组第K大元素
     *
     * @param nums 数组
     * @param k    k值
     *
     * @return 第k大元素
     */
    public static int findKthLargestByMinHeap(int[] nums, int k) {
        // 创建大小为K的小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // 遍历数组元素
        for (int num : nums) {
            // 构建最小堆，入堆大于堆顶的元素
            if (minHeap.size() < k || num > minHeap.peek()) {
                minHeap.offer(num);
            }

            // 移除Top k+1元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 弹出堆顶元素
        return minHeap.peek();

    }

    /**
     * 快速选择获取数组第K大元素
     *
     * @param nums 数组
     * @param k    k值
     *
     * @return 第k大元素
     */
    public static int findKthLargestByQuickSelect(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        // 初始化左右边界
        int left = 0, right = nums.length - 1;

        while (true) {
            // position（从0开始） 为当前的pivot的位置
            int position = partition(nums, left, right);

            // pivot + 1 则为第K大
            if (position + 1 == k) {
                return nums[position];
            } else if (position + 1 > k) {
                // 范围过大 缩小范围
                right = position - 1;
            } else {
                // 范围过小 增加范围
                left = position + 1;
            }
        }
    }


    private static int partition(int[] nums, int left, int right) {
        // left 默认为数组的第0个元素
        int pivot = left;

        // 开始位置（pivot下一位）
        int start = left + 1;
        // 结束位置（右侧最小数的位置）
        int end = right;

        while (start <= end) {
            //从左边找到第一个小于nums[pivot]的数
            while (start <= end && nums[start] >= nums[pivot]) {
                start++;
            }
            //从右边找到第一个大于nums[pivot]的数
            while (start <= end && nums[end] <= nums[pivot]) {
                end--;
            }

            if (start <= end && nums[start] < nums[pivot] && nums[end] > nums[pivot]) {
                swap(nums, start++, end--);
            }
        }
        //交换pivot到它所属的最终位置，也就是在start的位置，因为此时end的左边都比end大，右边都比end小
        swap(nums, pivot, end);
        return end; //返回最终pivot的位置
    }

    /**
     * 数组元素交换顺序
     *
     * @param nums
     * @param start
     * @param end
     */
    private static void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargestByMinHeap(nums, k));
        System.out.println(findKthLargestByQuickSelect(nums, k));
    }
}

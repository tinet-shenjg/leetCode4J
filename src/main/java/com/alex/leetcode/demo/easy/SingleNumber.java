package com.alex.leetcode.demo.easy;

/**
 * 136. 只出现一次的数字
 *
 * @author shenjiangang
 * @date 2020/04/27
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0] ^ nums[i];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }
}

package com.alex.leetcode.demo.medium;

/**
 * 跳跃游戏
 *
 * @author shenjiangang
 * @date 2020/04/17
 */
public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0}));
    }

    public static boolean canJump(int[] nums) {
        // 特殊值处理，长度为1必可达
        if (nums.length == 1) {
            return true;
        }

        // 长度大于1且开始为0 必不可达
        if (nums[0] == 0) {
            return false;
        }

        // 设置最大可达距离
        int maxJump = 0;

        // 遍历寻找是否可到达最远位置
        for (int i = 0; i < nums.length - 1; i++) {
            // 当前索引+当前位置的数即为当前位置的最大可达距离
            maxJump = Math.max(maxJump, i + nums[i]);

            // 当前位置不可前进
            if (maxJump == i) {
                return false;
            }
            // 是否可达最远位置
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

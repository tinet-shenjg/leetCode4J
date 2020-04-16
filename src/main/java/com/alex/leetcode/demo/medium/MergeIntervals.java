package com.alex.leetcode.demo.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间合并
 *
 * @author shenjiangang
 * @date 2020/04/16
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] arrays = {{1, 3}, {2, 6}, {8, 10}, {7, 18}};
        merge(arrays);
    }

    public static int[][] merge(int[][] intervals) {
        // 对intervals的区间上界进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int left, right;
        int r = 0;
        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];

            // 查找区间下界
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 缓存结果数据
            intervals[r][0] = left;
            intervals[r++][1] = right;
        }
        int[][] result = new int[r][2];
        for (int i = 0; i < r; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }
}

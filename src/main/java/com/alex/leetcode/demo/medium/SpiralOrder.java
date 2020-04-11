package com.alex.leetcode.demo.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author shenjiangang
 * @date 2020/04/11
 */
public class SpiralOrder {
    private static int DIRECTION_LEFT = 2;
    private static int DIRECTION_RIGHT = 0;
    private static int DIRECTION_UP = 3;
    private static int DIRECTION_DOWN = 1;

    public static List<Integer> spiralOrder(int[][] matrix) {
        // 特殊值校验
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList(m * n);

        // 设置遍历初始坐标和方向
        int row = 0, column = 0, direction = DIRECTION_RIGHT;

        // 设置路障
        boolean[][] obstacleArr = new boolean[m][n];

        // 遍历数组
        for (int i = 0; i < m * n; i++) {

            list.add(matrix[row][column]);
            obstacleArr[row][column] = true;

            // 向右移动
            if (direction == DIRECTION_RIGHT) {
                if (column < n - 1) {
                    column++;
                    // 避障转移
                    if (obstacleArr[row][column] == true) {
                        column--;
                        direction = DIRECTION_DOWN;
                    }
                } else {
                    direction = DIRECTION_DOWN;
                }

            }

            // 向下移动
            if (direction == DIRECTION_DOWN) {
                if (row < m - 1) {
                    row++;
                    // 避障转移
                    if (obstacleArr[row][column] == true) {
                        row--;
                        direction = DIRECTION_LEFT;
                    }
                } else {
                    direction = DIRECTION_LEFT;
                }
            }

            // 向左移动
            if (direction == DIRECTION_LEFT) {
                if (column > 0) {
                    column--;
                    // 避障转移
                    if (obstacleArr[row][column] == true) {
                        column++;
                        direction = DIRECTION_UP;
                    }
                } else {
                    direction = DIRECTION_UP;
                }
            }

            // 向上移动
            if (direction == DIRECTION_UP) {
                if (row > 0) {
                    row--;
                    // 避障转移，
                    if (obstacleArr[row][column] == true) {
                        row++;
                        // 结束了一个轮回，走内环,开始新的一轮
                        column++;
                        direction = DIRECTION_RIGHT;
                    }
                } else {
                    direction = DIRECTION_RIGHT;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        System.out.println(spiralOrder(matrix));
    }
}

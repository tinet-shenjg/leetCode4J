package com.alex.leetcode.demo.medium;

/**
 * 542. 01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 *
 * @author shenjiangang
 * @date 2020/04/15
 */
public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 0, 1, 1, 1, 0, 1, 1}, {1, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}};
        updateMatrix(matrix);
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        // 遍历矩阵
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            for (int columnIndex = 0; columnIndex < column; columnIndex++) {
                if (matrix[rowIndex][columnIndex] == 0) {
                    continue;
                } else {
                    findMinLength(matrix, rowIndex, columnIndex);
                }
            }
        }

        return matrix;
    }

    /**
     * 找出距离最短的0
     *
     * @param matrix
     * @param rowIndex
     * @param columnIndex
     */
    private static void findMinLength(int[][] matrix, int rowIndex, int columnIndex) {
        // 横向偏移量
        int xcount = 1;
        // 纵向偏移量
        int ycount = 1;

        // 环形圈宽度
        int width = 1;
        while (true) {
            // 中心行
            if (xcount == 1) {
                if (columnIndex - ycount >= 0 && (matrix[rowIndex][columnIndex - ycount] == 0)) {
                    matrix[rowIndex][columnIndex] = ycount;
                    return;
                }
                if (columnIndex + ycount < matrix[0].length && (matrix[rowIndex][columnIndex + ycount] == 0)) {
                    matrix[rowIndex][columnIndex] = ycount;
                    return;
                }

                ycount--;
            }

            // 向下 每下一层 rowIndex ++
            if (rowIndex + xcount < matrix.length) {
                // 左
                if (columnIndex - ycount >= 0 && matrix[rowIndex + xcount][columnIndex - ycount] == 0) {
                    matrix[rowIndex][columnIndex] = xcount + ycount;
                    return;
                }

                // 右
                if (columnIndex + ycount < matrix[0].length && matrix[rowIndex + xcount][columnIndex + ycount] == 0) {
                    matrix[rowIndex][columnIndex] = xcount + ycount;
                    return;
                }
            }

            // 向上 每上一层 rowIndex--
            if (rowIndex - xcount >= 0) {
                // 左
                if (columnIndex - ycount >= 0 && matrix[rowIndex - xcount][columnIndex - ycount] == 0) {
                    matrix[rowIndex][columnIndex] = xcount + ycount;
                    return;
                }


                // 右
                if (columnIndex + ycount < matrix[0].length && matrix[rowIndex - xcount][columnIndex + ycount] == 0) {
                    matrix[rowIndex][columnIndex] = xcount + ycount;
                    return;
                }
            }

            // 一轮结束，遍历下一圈数据
            if (ycount == 0) {
                width++;
                ycount = width;
                xcount = 1;
            } else {
                xcount++;
                ycount--;
            }

        }
    }


}

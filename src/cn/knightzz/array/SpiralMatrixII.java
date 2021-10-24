package cn.knightzz.array;

import java.util.Arrays;

/**
 * @author 王天赐
 * @title: SpiralMatrixII
 * @projectName leetcode-could
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/22 20:46
 */
public class SpiralMatrixII {


    public static void main(String[] args) {

        Solution solution = new SpiralMatrixII().new Solution();
        int[][] ints = solution.generateMatrix(4);

    }

    class Solution {

        //region 代码思路
        // 思路 :
        // 1. 确定区间 : [left, right)
        // 2. 把循环看做是一个
        //endregion

        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];

            // 定义循环次数, 每次循环会打印一层
            int loop = n / 2;

            // 定义每次循环的起始位置
            int startX = 0;
            int startY = 0;

            // 定义偏移量
            int offset = 1;

            // 定义填充数字
            int count = 1;

            // 定义中间位置
            int mid = n / 2;


            // 注意 下面循环是模拟外层的循环,相当于一层一层的环
            while (loop > 0) {

                int i = startX;
                int j = startX;

                // 模拟上层从左到右
                for (; j < startY + n - offset; ++j) {
                    res[i][j] = count++;
                }

                // 模拟右侧从上到下
                for (; i < startX + n - offset; ++i) {
                    res[i][j] = count++;
                }

                // 这里注意: startX 和 startY 表示初始位置, 移动区间是 [start, end)

                // 模拟下层从右到左
                for (; j > startY; j--) {
                    res[i][j] = count++;
                }

                // 模拟左侧从下到上
                for (; i > startX; i--) {
                    res[i][j] = count++;
                }

                // 循环层数减一
                loop--;

                // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
                startX += 1;
                startY += 1;

                // offset 控制每一圈里每一条边遍历的长度
                // 偏移值为什么加2 ? :
                // 1. 原因是因为在第二圈时, 行列长度各减一条边
                offset += 2;
            }

            // 考虑 n 为奇数的情况, 需要单独给矩阵最中间的位置赋值
            if (n % 2 != 0) {
                res[mid][mid] = count;
            }
            return res;
        }
    }
}

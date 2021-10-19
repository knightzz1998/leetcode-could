package cn.knightzz.array;

import java.util.Arrays;

/**
 * @author 王天赐
 * @title: SquaresOfAortedArray
 * @projectName leetcode-could
 * @description: 977. 有序数组的平方
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/19 20:51
 */


public class SquaresOfAortedArray {

    //region 思路
    // 1. 数据是排序过后的, 从小到大排序
    // 2. 要求 : 数字平方后也是按照从小到大的顺序排列的
    // to: 使用左右指针, 分别指向开头和结尾,因为数据是排好序的, 并且从小到大, 所以从较大的值大部分出现在两端(数据中有负值的情况下)
    // 比较两端的值的平方, 然后将较大的放到新数组, 然后对应指针继续移动, 边界条件是 left == right, 当二者相遇, 说明数据都取完了
    //endregion

    //region 题目
    // 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
    // 输入: nums = [-7,-3,2,3,11]
    // 输出: [4,9,9,49,121]
    //endregion

    public static void main(String[] args) {
        Solution solution = new SquaresOfAortedArray().new Solution();
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{})));
    }

    class Solution {
        public int[] sortedSquares(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int[] squareArray = new int[nums.length];

            for (int i = 0; i < nums.length; i++) {
                int leftVal = (int) Math.pow(nums[left], 2);
                int rightVal = (int) Math.pow(nums[right], 2);
                if (leftVal > rightVal) {
                    squareArray[nums.length - (i + 1)] = leftVal;
                    left++;
                } else {
                    squareArray[nums.length - (i + 1)] = rightVal;
                    right--;
                }
            }
            return squareArray;
        }
    }
}

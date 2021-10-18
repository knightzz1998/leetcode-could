package cn.knightzz.array;

import cn.knightzz.tools.ArrayGenerator;

/**
 * @author 王天赐
 * @title: BinarySearch
 * @projectName leetcode-could
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/16 14:46
 */
public class BinarySearch {

    public static void main(String[] args) {

        Solution solution = new BinarySearch().new Solution();
        int[] nums = ArrayGenerator.getRandomArray(10);
        System.out.println(solution.search(nums,2));

    }

    class Solution {
        public int search(int[] nums, int target) {
            // [a,b), 左闭右开区间
            int left = 0;
            int right = nums.length;
            // [23, 14, 55, 23] [0, 1, 2, 3]
            // 边界条件
            while (left < right) {
                // 获取中间数据的下标
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    // target 在右区间
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    // target 在左区间
                    right = mid;
                }
            }
            return -1;
        }

        public int search2(int[] nums, int target) {
            // [a,b], 左闭右闭区间
            int left = 0;
            int right = nums.length - 1;
            // [23, 14, 55, 23] [0, 1, 2, 3]
            // 边界条件
            while (left <= right) {
                // 获取中间数据的下标
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    // target 在右区间
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    // target 在左区间
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}

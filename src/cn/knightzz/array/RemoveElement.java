package cn.knightzz.array;

/**
 * @author 王天赐
 * @title: RemoveElement
 * @projectName leetcode-could
 * @description: 27. 移除元素
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/18 21:00
 */
public class RemoveElement {

    public static void main(String[] args) {

        Solution solution = new RemoveElement().new Solution();
        System.out.println(solution.removeElement(new int[]{1}, 2));
        System.out.println(solution.removeElement(new int[]{1}, 1));
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    //region 题目描述
    // 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
    // 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    // 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    // 链接：https://leetcode-cn.com/problems/remove-element
    //endregion

    //region 解题思路
    // 思路 : 双指针法
    // 1. 使用快慢指针, 开始时同时移动, 遇到val时, 慢指针停下, 快指针继续向前走,然后直到快指针遇到非val的值时停下
    // 2. 然后将快指针的值赋值给慢指针, 注意是赋值而不是交换, 然后慢指针继续向右移动
    // 3. 快指针的移动情况 : 任何情况都移动
    // 4. 慢指针的移动情况 : 决定慢指针是否移动,是由快指针决定的, 如果快指针不指向val时, 慢指针一直可以移动, 一旦快指针遇到val, 慢指针就得停下
    // 等到快指针找到非val元素即可
    //endregion

    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int slowIndex = 0;
            for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
                if (nums[fastIndex] != val) {
                    nums[slowIndex] = nums[fastIndex];
                    slowIndex++;
                }
            }
            return slowIndex;
        }
    }
}

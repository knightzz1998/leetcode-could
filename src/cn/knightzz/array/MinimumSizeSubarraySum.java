package cn.knightzz.array;

/**
 * @author 王天赐
 * @title: MinimumSizeSubarraySum
 * @projectName leetcode-could
 * @description: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/22 10:28
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, nums));
    }

    class Solution {


        //region 代码思路
        // 思路 : 滑动窗口
        // 1. 使用两个快慢指针, 最开始的时候慢指针不动, 快指针向前移动
        // 2. 将快指针移动经过的数据进行累加, 判断是否大于target
        // 3. 一旦找到大于target就记录[slow, fast]窗口的长度, 此时 当前窗口是满足条件的最大窗口, 里面的值都是临界值, 少一个都会不满足条件
        // 4. 下一步是缩小窗口, 先杀出慢指针指向的值, 然后
        // 5. 继续缩小窗口, 直到慢指针到达尾部
        //endregion

        public int minSubArrayLen(int target, int[] nums) {

            int left = 0;
            int sum = 0;
            int minLen = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                // 窗口移动
                // 当满足 sum >= target 时就, 移动窗口, 窗口缩小
                while (sum >= target) {
                    // 计算窗口大小
                    minLen = Math.min(minLen, right - left + 1);
                    sum -= nums[left++];
                }
            }

            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }
    }
}

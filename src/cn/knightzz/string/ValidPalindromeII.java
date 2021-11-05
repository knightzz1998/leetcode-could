package cn.knightzz.string;

/**
 * @author 王天赐
 * @title: ValidPalindromeII
 * @projectName leetcode-could
 * @description: https://leetcode-cn.com/problems/valid-palindrome-ii/
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/11/5 10:43
 */
public class ValidPalindromeII {

    public static void main(String[] args) {

        Solution solution = new ValidPalindromeII().new Solution();

        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome("cbbcc"));
    }

    class Solution {

        //region 题目描述
        // 给定一个非空字符串 s, 最多删除一个字符, 判断是否能成为回文字符串
        // s 由小写英文字母组成
        // 1. 题目意思是 : 你可以选择删除一个字符, 也可以选择不删除, 但是都要保证字符串是回文串
        //endregion

        public boolean validPalindrome(String s) {

            // 判断 s 是否为空
            if (s == null) {
                return false;
            }

            // 查找非回文串的位置
            Pair pair = findDifference(s, 0, s.length() - 1);

            // 可以选择删除一个字符, 也可以选择不删除, 但是都要保证字符串是回文串
            // 如果字符串已经是回文串了, 直接返回即可
            if (pair.left >= pair.right) {
                return true;
            }

            // 分别在不同的下标处去除一个字符判断是否还是回文串
            // 注意 : 不要写成 ++pair.left 和 --pair.right
            // 这样会改变 pair.left 和 pair.right 本身的值
            return isPalindrome(s, pair.left + 1 , pair.right) || isPalindrome(s, pair.left, pair.right - 1);
        }

        private boolean isPalindrome(String s, int left, int right) {
            Pair pair = findDifference(s, left, right);
            return pair.left >= pair.right;
        }

        private Pair findDifference(String s, int left, int right) {

            while (left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }

            return new Pair(left, right);
        }

        private class Pair {

            int left;
            int right;

            public Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
    }

}

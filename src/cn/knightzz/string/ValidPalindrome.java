package cn.knightzz.string;

/**
 * @author 王天赐
 * @title: ValidPalindrome
 * @projectName leetcode-could
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/11/4 19:04
 */
public class ValidPalindrome {


    public static void main(String[] args) {

    }


    //region 题目描述
    // 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    // 说明：本题中，我们将空字符串定义为有效的回文串。
    //endregion

    class Solution {
        public boolean isPalindrome(String s) {

            if (s == null) {
                return false;
            }

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {

                // 控制左指针移动, 当指向非数字和字母的时候向右移动
                // 参考滑动窗口的循环控制方式
                while (left < right && !isValid(s.charAt(left))) {
                    left++;
                }

                while (left < right && !isValid(s.charAt(right))) {
                    right--;
                }

                // 判断是否是回文串
                if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
                    return false;
                }

                left++;
                right--;
            }
            return true;
        }

        private boolean isEqual(char left, char right) {
            return Character.toLowerCase(left) == Character.toLowerCase(right);
        }

        private boolean isValid(char c) {
            return Character.isLetter(c) || Character.isDigit(c);
        }
    }

}

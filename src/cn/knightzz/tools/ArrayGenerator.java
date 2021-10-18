package cn.knightzz.tools;

/**
 * @author 王天赐
 * @title: ArrayGenerator
 * @projectName leetcode-could
 * @description:
 * @website http://knightzz.cn/
 * @github https://github.com/knightzz1998
 * @date 2021/10/16 14:52
 */
public class ArrayGenerator {


    public static int[] getRandomArray(int length) {

        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            int value = (int) (Math.random() * 10);
            arr[i] = value;
        }
        return arr;
    }

}

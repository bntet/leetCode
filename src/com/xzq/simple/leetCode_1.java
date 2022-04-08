package com.xzq.simple;

public class leetCode_1 {

    public static int[] twoSum(int[] nums, int target) {
        for (int num : nums) {
            for (int num2 : nums) {
                int targer2 = target;
                if((num + num2) == targer2){
                    return new int[]{num, num2};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] intList = twoSum(nums, 9);
        System.out.println(intList[0] + "," + intList[1]);
    }
}

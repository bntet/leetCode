package com.xzq.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 */
public class leetCode_1 {

    /**
     * 使用两个for循环
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int num : nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int i1 = i+1; i1 < nums.length; i1++) {
                    if((nums[i] + nums[i1]) == target){
                        return new int[]{nums[i], nums[i1]};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 使用hash表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumFunction2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int[] intList = twoSum(nums, 9);
        System.out.println("================两个for================");
        System.out.println(intList[0] + "," + intList[1]);
        System.out.println("================哈希表================");
        int[] ints = twoSumFunction2(nums, 9);
        System.out.println(ints[0] + "," + ints[1]);
    }
}

package com.xzq.difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4.寻找两个正序数组的中位数
 * O(log(m + n))
 */
public class leetCode_4 {
    public static void main(String[] args) {
        double num = findMedianSortedArrays1(new int[]{1, 5}, new int[]{2,3,4});
        System.out.println(num);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[] nums3 = new int[l1+l2];

        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < l1 || p2 < l2){
            if(p1 == l1){
                nums3[p3] = nums2[p2++];
            }else if(p2 == l2){
                nums3[p3] = nums1[p1++];
            }else if(nums1[p1] > nums2[p2]){
                nums3[p3] = nums2[p2++];
            }else{
                nums3[p3] = nums1[p1++];
            }
            p3++;
        }

        int yu = nums3.length / 2;
        int mo = nums3.length % 2;

        double median = 0.0;
        if(mo == 0){
            //偶数
             median = (nums3[yu]+nums3[yu-1]) / 2.0;
        }else{
            //奇数
            median = nums3[yu];
        }
        return median;
    }
}

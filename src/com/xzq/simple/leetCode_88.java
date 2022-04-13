package com.xzq.simple;

import java.util.Arrays;

/**
 * 88.合并两个有序数组
 */
public class leetCode_88 {

    public static void main(String[] args) {
//        merge1(new int[]{1,2,4,0,0,0}, 3, new int[]{9,1,4}, 3);
        merge2(new int[]{1,2,4,0,0,0}, 3, new int[]{1,4,9}, 3);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //定义指针1、2，指向数组末尾
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 || p2 >= 0){
            if (p1 == -1){
                nums1[p] = nums2[p2--];
            } else if(p2 == -1){
                nums1[p] = nums1[p1--];
            } else if(nums1[p1] < nums2[p2]){
                nums1[p] = nums2[p2--];
            } else if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1--];
            } else if(nums1[p1] == nums2[p2]){
                nums1[p] = nums1[p1--];
            }
            p--;
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}

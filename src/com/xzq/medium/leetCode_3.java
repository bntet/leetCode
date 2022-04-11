package com.xzq.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3.无重复字符的最长子串
 */
public class leetCode_3 {
    public static void main(String[] args) {
        int num = lengthOfLongestSubstring("abcabcbb");
        System.out.println(num);
    }

    public static int lengthOfLongestSubstring(String s) {
        //用于存储字符串子串
        Set<Character> charSet = new HashSet<>();
        //字符串长度
        int sL = s.length();
        //定义右指针
        int rk = 0;
        //存储子串长度
        int num = 0;
        for (int i = 0; i < sL; i++) {
            if(i != 0){
                charSet.remove(s.charAt(i - 1));
            }
            while (rk < sL && !charSet.contains(s.charAt(rk))){
                charSet.add(s.charAt(rk));
                ++rk;
            }
            num = Math.max(num, rk - i);
        }
        return num;
    }
}

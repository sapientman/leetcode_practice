package com.java.leetcode.lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/7/28 10:49
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        // 哈希表解法
//        int i = lengthOfLongestSubstring1(s);
        // 滑动窗口算法
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);
    }
    /**
     * 哈希表解法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap();
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i], i);
                num++;
            }
        }
        return num;
    }
    /**
     * 滑动窗口算法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: [字节题库]剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author: lmwis
 * @Date 2020-12-04 21:05
 * @Version 1.0
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


    public static int lengthOfLongestSubstring(String s) {
        int left = -1;
        int right = 0;
        int res=0;
        Map<Character,Integer> hashMap = new HashMap<>();
        for(;right<s.length();right++){
            char c = s.charAt(right);
            if(hashMap.containsKey(c)){
                left = Math.max(left,hashMap.get(c));
            }
            hashMap.put(c,right);
            res = Math.max(res,right-left);
        }

        return res;
    }

}

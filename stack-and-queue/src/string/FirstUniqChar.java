package string;

/**
 * @Description: 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * @Author: lmwis
 * @Date 2020-12-23 11:15
 * @Version 1.0
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {

        int[] bucket = new int[26];
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            bucket[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(bucket[c-'a']==1){
                return i;
            }
        }
        return -1;
    }
}

package string;

import java.util.Arrays;

/**
 * @Description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * @Author: lmwis
 * @Date 2020-11-22 17:57
 * @Version 1.0
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        for(int i=0;i<s.length();i++){
            if(sc[i]!=tc[i]){
                return false;
            }
        }

        return true;
    }

}

package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 【经典回溯】
 * @Author: lmwis
 * @Data: 2021/6/22 4:37 下午
 * @Version: 1.0
 */
public class Permutation {

    public String[] permutation(String s) {

        char[] c = s.toCharArray();
        List<String> res = new ArrayList<>();

        dfs(0,c,s,res);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int pos, char[] c, String s, List<String> res){
        if(pos == s.length()-1){
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> repeat = new HashSet<>();
        for(int i=pos;i<c.length;i++){
            char c1 = c[i];
            if(repeat.contains(c1)){
                continue;
            }
            repeat.add(c1);
            swap(i,pos,c);
            dfs(pos+1,c,s,res);
            swap(i,pos,c);

        }
    }
    private void swap(int i, int x,char[] c) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}

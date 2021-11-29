package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/11/29 8:00 下午
 * @Version: 1.0
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("lettcode"));
    }
    public char firstUniqChar(String s) {
        if(s.length()==1){
            return s.charAt(0);
        }
        int[] sets = new int[26];
        List<Character> lists = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if (!lists.contains(s.charAt(i))) lists.add(s.charAt(i));
            sets[s.charAt(i)-'a']++;
        }
        char res = ' ';
        res = lists.stream().filter(k->sets[k-'a']==1).findFirst().orElse(' ');
        return res;
    }
}

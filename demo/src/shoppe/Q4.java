package shoppe;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/16 12:08 下午
 * @Version: 1.0
 */
public class Q4 {
    public static void main(String[] args) {

    }

    /**
     * pwwkew
     * pw wke w
     * @param str
     * @return
     */
    public int method(String str){
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(set.contains(c)){
                // 分段
                max = Math.max(max,set.size());
                set = new HashSet<>();
            }else{
                set.add(c);
            }
        }

        return max;
    }
}

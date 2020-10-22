package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 划分字母区间
 * @Author: lmwis
 * @Date 2020-10-22 9:42
 * @Version 1.0
 */
public class DivideStringInterval {
    public static void main(String[] args) {
        DivideStringInterval divideStringInterval = new DivideStringInterval();
        String s = "ababcbacadefegdehijhklij";
        divideStringInterval.partitionLabels(s).forEach(System.out::print);
    }

    // 贪心+双指针
    // start and end
    private List<Integer> partitionLabels(String s) {
        int start=0;
        int end=0;
        int length=s.length();
        Map<Character,Integer> map = new HashMap<>();
        // 找到每个字符最后出现的位置
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 不存在
            if (!map.containsKey(c)){
                map.put(c,i);
            }else {
                map.replace(c,i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int lastC = map.get(c);
            end = Math.max(end,lastC);
            if(i==end){
                list.add(end-start+1);
                start = end+1;
            }
        }
        return list;
    }
}

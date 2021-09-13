package tongcheng;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/11 8:31 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        
    }

    public int[] find (int[] arg) {
        // write code here

        List<Integer> res = new ArrayList<>();
        List<Integer> map = new ArrayList<>();
        for (int i = 0; i < arg.length; i++) {
            if (map.contains(arg[i])){
                res.remove(new Integer(arg[i]));
            }else{
                res.add(new Integer(arg[i]));
                map.add((arg[i]));
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}

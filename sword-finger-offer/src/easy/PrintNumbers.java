package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/18 12:03 下午
 * @Version: 1.0
 */
public class PrintNumbers {
    public static void main(String[] args) {
        Arrays.stream(new PrintNumbers().printNumbers(2)).forEach(System.out::println);
    }
    public int[] printNumbers(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<=n;i++){
            int max = 10;
            for(int j=2;j<=i;j++){
                max *= 10;
            }
            for(int k=1;k<max;k++){
                if(!res.contains(k)){
                    res.add(k);
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

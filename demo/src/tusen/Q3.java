package tusen;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/18 7:51 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int k =in.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.next();
        }

    }
    public static List<String> getSim(String[] strs,int k){
        int count = k;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i; j < strs.length; j++) {
                if (isSim(strs[i],strs[j])){

                }
            }
        }
        return null;

    }
    public static Boolean isSim(String s1,String s2){
        if (s1.length()!=s2.length()) return false;
        byte[] s1Bytes = s1.getBytes(StandardCharsets.UTF_8);
        byte[] s2Bytes = s2.getBytes(StandardCharsets.UTF_8);
        Arrays.sort(s1Bytes);
        Arrays.sort(s2Bytes);
        for (int i = 0; i < s1.length(); i++) {
            if (s1Bytes[i]!=s2Bytes[i]){
                return false;
            }
        }
        return true;
    }
}

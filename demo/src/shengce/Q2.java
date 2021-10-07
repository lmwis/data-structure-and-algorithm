package shengce;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/10/7 8:21 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        Map<Integer,Integer> maps = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='('){
                stack.push(i);
            }else if (str.charAt(i)==')'){
                maps.put(stack.pop(),i);
            }
        }
        System.out.println(maps.size());
        maps.forEach((a,b)->{
            System.out.println(a);
            System.out.println(b);
        });
    }
}

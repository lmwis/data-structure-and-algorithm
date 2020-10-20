import java.util.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-14 20:14
 * @Version 1.0
 */
public class StringTest {
    public static void main(String[] args) {
        String str ="hello";
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            char c = str.charAt(i);
        }
        List<Map<String,Integer>> l = new ArrayList<>();
        Map<Character,Integer> mapInStr = new HashMap();
        if(mapInStr.get('c')==null ){
            System.out.println(true);
        }
//        mapInStr.containsKey()

        Stack<String> stack = new Stack<>();
    }
}

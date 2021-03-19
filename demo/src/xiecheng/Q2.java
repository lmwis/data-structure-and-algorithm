package xiecheng;

import java.io.IOException;
import java.util.*;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-18 20:13
 * @Version 1.0
 */
public class Q2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Map<String, List<String>> dict = new HashMap<>();
        while (in.hasNextLine()) {
            String lin = in.nextLine();
            if(lin.startsWith("dict")){
                String[] part = lin.split(":");
                List<String> words = new ArrayList<>();
                for(String str:part[2].split(",")){
                    words.add(str);
                }
                dict.put(part[1],words);
            }else if(lin.startsWith("query")){
                String str = lin.split(":")[1];
            }
        }
        System.out.println(dict);
    }

}

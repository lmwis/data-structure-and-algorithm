package string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/11/8 1:36 下午
 * @Version: 1.0
 */
public class GetHint {
    public static void main(String[] args) {
        System.out.println(new GetHint().getHint("1123","0111"));
    }
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow=0;
        String secretStr = "";
        String guessStr = "";
        Map<String,Integer> maps = new HashMap<>();
        int[] bucket = new int[10];
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
            }else{
                bucket[new Integer(secret.charAt(i)+"")]++;
                secretStr =secretStr + secret.charAt(i);
                guessStr= guessStr+guess.charAt(i);
            }
        }
        for(int i=0;i<guessStr.length();i++){
            if(bucket[new Integer(guessStr.charAt(i)+"")]>0){
                bucket[new Integer(guessStr.charAt(i)+"")]--;

                cow++;
            }
        }
        return bull+"A"+cow+"B";
    }
}

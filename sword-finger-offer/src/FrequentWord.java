import java.util.*;

/**
 * @Description: 出现
 * @Author: lmwis
 * @Date 2020-10-22 16:24
 * @Version 1.0
 */
public class FrequentWord {
    public static void main(String[] args) {
        FrequentWord frequentWord = new FrequentWord();
        String A ="apple apple apple";
        String B = "banana";
        for (String s : frequentWord.method(A, B)) {
            System.out.println(s);
        }
    }

    public String[] method(String A,String B){

        String[] sA = A.split(" ");
        String[] sB = B.split(" ");
        Map<String,Integer> mapA = new HashMap<>();
        Map<String,Integer> mapB = new HashMap<>();
        for (String s: sA) {
            if(!mapA.containsKey(s)){
                mapA.put(s,1);
            }else{
                int count = mapA.get(s)+1;
                mapA.replace(s,count);
            }
        }
        for (String s: sB) {
            if(!mapB.containsKey(s)){
                mapB.put(s,1);
            }else{
                int count = mapB.get(s)+1;
                mapB.replace(s,count);
            }
        }
        List<String> list = new ArrayList<>();
        filter(mapB, mapA, list);
        filter(mapA, mapB, list);
        return list.toArray(new String[0]);
    }

    private void filter(Map<String, Integer> mapA, Map<String, Integer> mapB, List<String> list) {
        Set<String> setB = mapB.keySet();
        Iterator itB = setB.iterator();
        while(itB.hasNext()){
            String s = (String)itB.next();
            if(!mapA.containsKey(s) && mapB.get(s)==1){
                list.add(s);
            }
        }
    }
}

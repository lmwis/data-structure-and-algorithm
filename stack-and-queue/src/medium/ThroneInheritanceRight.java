package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/20 10:34 上午
 * @Version: 1.0
 */
public class ThroneInheritanceRight {
    public static void main(String[] args) {
        ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());
        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder());

    }
    Map<String,List<String>> edge = new HashMap<>();
    Map<String,Integer> memberStatusMap = new HashMap<>(); // 0-alive 1-dead
    String king ;

    public ThroneInheritanceRight(String kingName) {
        this.king = kingName;
        memberStatusMap.put(king,0);
    }

    public void birth(String parentName, String childName) {

        memberStatusMap.put(childName,0);
        List<String> orDefault = edge.getOrDefault(parentName, new ArrayList<>());
        orDefault.add(childName);
        edge.put(parentName,orDefault);
    }

    public void death(String name) {
        memberStatusMap.put(name,1);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        preOrder(res,king);
        return  res;
    }
    public void preOrder(List<String> res,String name){
        if(memberStatusMap.get(name)==0){
            res.add(name);
        }
        List<String> orDefault = edge.getOrDefault(name, new ArrayList<>());
        orDefault.forEach(k->{
            preOrder(res,k);
        });

    }
}

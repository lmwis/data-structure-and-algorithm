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
public class ThroneInheritance {
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
    Map<String,List<String>> child = new HashMap<>();
    List<String> res = new ArrayList<>();
    Map<String,Integer> memberStatusMap = new HashMap<>(); // 0-alive 1-dead
    String king ;
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        res.add(king);
        memberStatusMap.put(king,0);
    }
    private String getLastChild(String parent){ // 获取最年长的孩子
        String lastChild;
        List<String> orDefault = child.getOrDefault(parent, new ArrayList<>());
        if(orDefault.size()==0){
            return parent;
        }else { // 应该获取所有孩子的最后一个
            List<String> cc = child.get(orDefault.get(orDefault.size()-1));
            lastChild = orDefault.get(orDefault.size()-1);
            if (cc!=null && cc.size()>=1){
                lastChild = getLastChild(orDefault.get(orDefault.size()-1));
            }
            return lastChild;

        }
    }
    public void birth(String parentName, String childName) {

        String lastChild = "";
        memberStatusMap.put(childName,0);
        List<String> orDefault = child.getOrDefault(parentName, new ArrayList<>());
        lastChild = getLastChild(parentName);
        orDefault.add(childName);
        child.put(parentName,orDefault);
        final String last = lastChild;
        List<String> newArray = new ArrayList<>();
        res.forEach(k->{
            newArray.add(k);
            if(k.equals(last)){
                newArray.add(childName);
            }
        });
        this.res = newArray;
    }

    public void death(String name) {
//        Integer integer = memberStatusMap.get(name);
        memberStatusMap.put(name,1);
    }

    public List<String> getInheritanceOrder() {
        List<String> resExDeath = new ArrayList<>();
        res.forEach(k->{
            if(memberStatusMap.get(k) == 0 ){
                resExDeath.add(k);
            }
        });
        return  resExDeath;
    }
}

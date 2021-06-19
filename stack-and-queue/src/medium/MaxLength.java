package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/6/19 2:43 下午
 * @Version: 1.0
 */
public class MaxLength {
    public static void main(String[] args) {
        System.out.println(new MaxLength().maxLength(new ArrayList<String>(){{
            add("cha");
            add("r");
            add("act");
            add("ers");
        }}));
    }
    int ans = 0;
    /**
     * 用二进制位表示拼接后的字符串
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        List<Integer> marks = new ArrayList<>();
        arr.forEach(s->{
            int mask = 0;
            for(int i=0;i<s.length();i++){
                int index = s.charAt(i)-'a';
                if(((mask>>index)&1)!=0){ // mask的第index位不为0，说明有重复字母
                    mask = 0;
                    break;
                }
                mask |= 1<<index; // 将mask的第index位变为1
            }
            if(mask != 0){
                marks.add(mask);
            }
        });
        backtrack(marks,0,0);
        return ans;
    }
    public void backtrack(List<Integer> marks,int pos,int mark){
        if(pos==marks.size()){
            ans = Math.max(ans,Integer.bitCount(mark));
            return;
        }
        if((mark & marks.get(pos))==0){ // 没有公共元素
            backtrack(marks,pos+1,mark | marks.get(pos) );
        }
        // 回溯
        backtrack(marks,pos+1,mark);
    }
}

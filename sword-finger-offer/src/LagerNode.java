import data.structure.LinkedList;
import data.structure.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: 往下更大的节点
 * [2,7,4,3,5]
 * [7,0,5,5,0]
 * @Author: lmwis
 * @Date 2020-10-22 17:36
 * @Version 1.0
 */
public class LagerNode {
    public static void main(String[] args) {
        LagerNode lagerNode = new LagerNode();
//        int[] arr = new int[]{2,7,4,3,5};
        LinkedList linkedList = new LinkedList();
        System.out.println(Arrays.toString(lagerNode.getLargerNode(linkedList.root)));
    }

    /**
     * [2,7,4,3,5] -> [7,0,5,5,0]
     * 暴力
     * @param root
     * @return
     */
    public int[] getLargerNode(ListNode root){
        ListNode node = root;
        ListNode point;
        List<Integer> res = new java.util.LinkedList<>();
        while(node!=null){
            int max = node.getValue();
            point = node.getNext();
            while(point!=null){
                if(point.getValue()>max){
                    max = point.getValue();
                }
                point = point.getNext();
            }
            if(max==node.getValue()){
                res.add(0);
            }else {
                res.add(max);
            }
            node = node.getNext();
        }
        return  res.stream().mapToInt(Integer::valueOf).toArray();

    }


}

package wangyi;


/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-04-10 15:22
 * @Version 1.0
 */
public class Q2 {

    public ListNode minusList (ListNode minuendList, ListNode subtrahendList) {
        // write code here
        ListNode p1 = minuendList;
        ListNode p2 = subtrahendList;
        int n1 = 0;
        String str1="";
        while(p1!=null){
            str1 += String.valueOf(p1.value);
            p1=p1.next;
        }
        n1 = Integer.parseInt(str1);
        int n2 = 0;
        String str2="";
        while(p2!=null){
            str2 += String.valueOf(p2.value);
            p2=p2.next;
        }
        n2 = Integer.parseInt(str1);
        int res = n1-n2;
        String resStr = String.valueOf(res);
        if(resStr.length()<=0){
            return null;
        }
        ListNode resList = new ListNode();
        ListNode head = resList;
        head.value = Integer.parseInt(resStr.charAt(0)+"");
        for(int i=1;i<resStr.length();i++){
            ListNode temp = new ListNode();
            temp.value = Integer.parseInt(resStr.charAt(i)+"");
            head.next = temp;
            head = temp;
        }
        return resList;
    }

}
class ListNode{
    int value;
    ListNode next;
}

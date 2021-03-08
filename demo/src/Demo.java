/**
 * @Description:
 *  一个字符串s，包含一个或者多个*，把*全部移动到最左边，打印出来
 * @Author: lmwis
 * @Date 2021-03-08 10:46
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        String str = "askjdhaw**akhwd**";
        System.out.println(new Demo().function(str));
    }

    public String function(String s){
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c!='*'){
                sb.append(c);
            }else {
                count++;
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i=0;i<count;i++){
            result.append("*");
        }
        result.append(sb);
        return result.toString();
    }
}

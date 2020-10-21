package easy;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-21 19:29
 * @Version 1.0
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = "We are happy.";
        System.out.println(replaceSpace.replaceSpace(s));
    }

    public String replaceSpace(String s){
        StringBuffer str = new StringBuffer();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' '){
                str.append("%20");
            }else{
                str.append(c);
            }
        }
        return str.toString();
    }
}

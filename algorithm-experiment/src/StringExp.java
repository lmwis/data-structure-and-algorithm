/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-03 22:53
 * @Version 1.0
 */
public class StringExp {
    String str = new String("good");
    char[] c = new char[]{'a','b','c','d'};
    // 因为这个str是作为字面量传过来的，就跟基本数据类型一样，没有引用
    public void change(String str,char[] c){
        str  = "bad";
        c[0]='x';
    }

    public static void main(String[] args) {
        StringExp stringExp = new StringExp();
        stringExp.change(stringExp.str,stringExp.c);
        System.out.println(stringExp.str);
        System.out.println(stringExp.c);
    }
}

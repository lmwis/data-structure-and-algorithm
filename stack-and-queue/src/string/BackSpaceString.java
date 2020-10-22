package string;

import java.util.Stack;

/**
 * @Description: 比较含退格的字符串
 * @Author: lmwis
 * @Date 2020-10-19 20:05
 * @Version 1.0
 */
public class BackSpaceString {
    public static void main(String[] args) {
        // "abcd"
        //"bbcd"
        BackSpaceString backSpaceString = new BackSpaceString();
        System.out.println(backSpaceString.backspaceCompare("abcd","bbcd"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(int i=0;i<S.length();i++){
            char c =  S.charAt(i);
            if(c=='#' && !stackS.empty()){
                stackS.pop();
            }else if(c!='#'){
                stackS.push(c);
            }
        }
        for(int i=0;i<T.length();i++){
            char c =  T.charAt(i);
            if(c=='#'){
                if(!stackT.empty()){
                    stackT.pop();
                }
            }else if(c!='#'){
                stackT.push(c);
            }
        }
        if(stackS.size()!=stackT.size()){
            return false;
        }
        int length = stackS.size();
        for(int i=0;i<length;i++){
            if(!(stackS.pop()).equals(stackT.pop())){
                return false;
            }
        }
        return true;
    }
}

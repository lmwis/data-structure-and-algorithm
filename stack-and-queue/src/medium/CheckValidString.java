package medium;

/**
 * @Description: 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 *
 * @Author: lmwis
 * @Data: 2021/12/16 3:07 下午
 * @Version: 1.0
 */
public class CheckValidString {
    public boolean checkValidString(String s) {
        int max = 0;
        int min = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                max++;
                min++;
            }else if(s.charAt(i) == ')'){
                max--;
                min = min==0?0:min-1;
                if(max<0){
                    return false;
                }
            }else{
                min = min==0?0:min-1;
                max++;
            }
        }
        if(min==0){
            return true;
        }else{
            return false;
        }
    }
}

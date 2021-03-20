package didi;

import java.util.Scanner;

/**
 * @Description:
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给一个字符串s，你可以至多选择两个不同位置的字符进行交换（可以选择不交换，保留原串），问所有可能中字典序最小的串。
 *
 * 有关字典序：对于长度相同的串a和串b，串a的字典序小于串b当且仅当存在一个位置i使得串a和串b的前i-1个字符完全相同且串a的第i个字符小于串b的第i个字符。即a1=b1,a2=b2,...ai-1=bi-1且ai<bi。
 *
 *
 *
 * 输入描述
 * 一行一个字符串s，保证串中都为小写字母('a'~'z')。字符串长度<=200000
 *
 * 输出描述
 * 输出一个串t，表示所有可能中字典序最小的串。
 *
 *
 * 样例输入
 * aaazbcdeadcd
 * 样例输出
 * aaaabcdezdcd
 * @Author: lmwis
 * @Date 2021-03-20 19:16
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(new Q1().function(input.next()));

    }

    /**
     * 把a放到最前面？
     * @param s
     * @return
     */
    public String function(String s){

        for(int i=0;i<26;i++){
            char c = (char)(i+'a');
            int i1 = s.lastIndexOf(c);
            int i2 =0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)>s.charAt(i1)){
                    i2 = j;
                    break;
                }
            }
            if(i1>i2){
                return s.substring(0,i2)+s.charAt(i1)+s.substring(i2+1,i1)+s.charAt(i2)+s.substring(i1+1);
            }
        }

        return s;
    }
}

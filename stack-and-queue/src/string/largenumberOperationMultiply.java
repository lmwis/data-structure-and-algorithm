package string;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-12-15 20:55
 * @Version 1.0
 */
public class largenumberOperationMultiply {

    /**
     * 定义方法multiply的功能
     * @param str1
     * @param str2
     * @return
     */
    public String multiply(String str1,String str2){

        int[] num1 = new int[str1.length()];
        int[] num2 = new int[str2.length()];
        int[] result = new int[str1.length() + str2.length()];

        //将两个字符串转成整型数组，顺序转换，数组下标越小，数字对应的位数越高
        for (int i = 0;i < str1.length(); i++){
            num1[i] = Integer.parseInt(str1.substring(i,i+1));
        }
        for (int i = 0;i < str2.length(); i++){
            num2[i] = Integer.parseInt(str2.substring(i,i+1));
        }

        //两大数相乘
        for (int a = 0;a < str1.length(); a++){
            for (int b = 0;b < str2.length(); b++){
                result[a+b] += num1[a]*num2[b];
            }
        }

        ////判断是否需要进位，满10进1,因为存储顺序与位数高低相反，所以采用逆序进位
        int temp;
        for (int k = result.length-1; k > 0; k--){
            temp=result[k]/10;  //数组下标大的向数组下标小的进位
            result[k-1] += temp;
            result[k] = result[k]%10;
        }

        //将结果数组逆序转化为字符串
        String resultstr = "";
        for (int i = 0; i < result.length-1; i++){
            resultstr += "" + result[i];
        }
        return resultstr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        String str1 = sc.next();
        System.out.println("请输入第二个数：");
        String str2 = sc.next();
        largenumberOperationMultiply bn = new largenumberOperationMultiply();
        //创建类largenumberOperationMultiply的对象bn
        String output = bn.multiply(str1,str2);
        //bn对象调用multiply方法对str1和str2进行操作
        System.out.println(str1+"与"+str2+"的积为="+output);
    }
}
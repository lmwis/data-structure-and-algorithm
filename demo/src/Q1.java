import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-15 19:13
 * @Version 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if ((a | b) == c) {
                res[i]=0;
            } else {
                // 0-1-0 1次
                // 1-1-0 2次
                // 0-0-1 1次 其余情况均不需要
                int sum = 0;
                String aBinary = toBinary(a);
                String bBinary = toBinary(b);
                String cBinary = toBinary(c);
                if(aBinary.length()>=bBinary.length() && aBinary.length()>=cBinary.length()){
                    bBinary = fullBinary(bBinary,aBinary.length());
                    cBinary = fullBinary(cBinary,aBinary.length());
                }else if(bBinary.length()>=aBinary.length() && bBinary.length()>=cBinary.length()){
                    aBinary = fullBinary(aBinary,bBinary.length());
                    cBinary = fullBinary(cBinary,bBinary.length());
                }else {
                    aBinary = fullBinary(aBinary,cBinary.length());
                    bBinary = fullBinary(bBinary,cBinary.length());
                }
                for(int j=aBinary.length()-1;j>=0;j--){
                    sum+=judge(aBinary.charAt(j),bBinary.charAt(j),cBinary.charAt(j));
                }
                res[i]=sum;
            }
        }
        Arrays.stream(res).forEach(System.out::println);
    }
    public static String fullBinary(String binaryStr,int length){
        StringBuffer temp = new StringBuffer();
        for(int i=binaryStr.length()-1;i>=0;i--){
            temp.append(binaryStr.charAt(i));
        }
        for(int i=binaryStr.length();i<length;i++) {
            temp.append("0");
        }
        StringBuffer res = new StringBuffer();
        for(int i=temp.length()-1;i>=0;i--){
            res.append(temp.charAt(i));
        }
        return res.toString();

    }
    public static String toBinary(int num){
        StringBuffer sb = new StringBuffer();
        while(num>0){
            if(num%2==0){
                sb.append("0");
            }else{
                sb.append("1");
            }
            num = num/2;
        }
        StringBuffer res = new StringBuffer();
        for(int i=sb.length()-1;i>=0;i--){
            res.append(sb.charAt(i));
        }
        return res.toString();
    }
    public static int judge(char a,char b,char  c){
        if((a=='0' && b=='1' && c=='0') ||(a=='0'&&b=='0'&&c=='1')||(a=='1' && b=='0' && c=='0')){
            return 1;
        }else if((a=='1'&&b=='1'&&c=='0')){
            return 2;
        }else{
            return 0;
        }

    }
}

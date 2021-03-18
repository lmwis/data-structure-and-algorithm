package xiecheng;

import java.util.Scanner;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2021-03-18 19:04
 * @Version 1.0
 */
public class Q1 {

    static int calcSimilarity(String name1, String name2) {
        String[] name1List = name1.split(" ");
        String[] name2List = name2.split(" ");
        int sum=0;
        for(int i=0;i<(name1List.length>name2List.length?name2List.length:name1List.length);i++){// 遍历小的
            String temp1 = name1List[i];
            String temp2 = name2List[i];

            int t1 = temp1.length();
            int t2 = temp2.length();
            int[][] dp = new int[t1 + 1][t2+1];

            // 找公共字串
            StringBuilder res = new StringBuilder();
            for (int j= 0; j < t1; j++) {
                for (int k = 0; k < t2; k++) {
                    // 获取两个串字符
                    char c1 = temp1.charAt(j), c2 = temp2.charAt(k);
                    if (c1 == c2) {
                        // 去找它们前面各退一格的值加1即可
                        res.append(c1);
                        dp[j + 1][k + 1] = dp[j][k] + 1;
                    } else {
                        dp[j + 1][k + 1] = Math.max(dp[j + 1][k], dp[j][k + 1]);
//                        sum+=c1;
//                        System.out.println("=="+c1);
                    }
                }
            }
            sum = getSum(sum, temp1, res);
            sum = getSum(sum, temp2, res);

        }

        if(name1List.length>name2List.length){
            int start = name1List.length-name2List.length;
            for(int i=start;i<name1List.length;i++){
                String temp = name1List[i];
                for(int j=0;j<temp.length();j++){
                    sum+=temp.charAt(j);
                }
            }
        }else if(name2List.length>name1List.length){
            int start = name2List.length-name1List.length;
            for(int i=start;i<name2List.length;i++){
                String temp = name2List[i];
                for(int j=0;j<temp.length();j++){
                    sum+=temp.charAt(j);
                }
            }
        }

        return sum;
    }

    private static int getSum(int sum, String temp1, StringBuilder res) {
        int index1 = 0;
        int index2=0;
        while(index1<temp1.length()||index2<res.length()){
            if(index1>=res.length()&&index2>=res.length()){
                sum+=temp1.charAt(index1);
                index1++;
                continue;
            }
            if(temp1.charAt(index1)==res.charAt(index2)){
                index1++;
                index2++;
            }else{
                sum+=temp1.charAt(index1);
                index1++;
            }

        }
        return sum;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String name1 = in.nextLine();
            String name2 = in.nextLine();

            int sum = calcSimilarity(name1, name2);
            System.out.println(sum);
        }
    }
}

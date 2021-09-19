package tusen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/18 6:40 下午
 * @Version: 1.0
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String c = in.next();
        int mu = 0;
        int le = 0;
        int eq = 0;
        int count = 0;
        int max = 0;
        int min=0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i)=='+'){
                mu++;
                count++;
            }else if(c.charAt(i)=='-'){
                le++;
                count--;

            }else{
                eq++;
            }

            max = Math.max(count,max);
            min = Math.min(count,min);
        }
        int line = (max-min)==0?1:(max-min);
        String[][] res = new String[line][n];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = ".";
            }
        }
        char last;
        int temp = 0;
        if (mu>le&&mu-le>=le){
            temp = line-1;
        }else if(le>mu&&le-mu>=mu){
//            temp = 0;
        }else{
            temp = max+min;
        }
        if (c.charAt(0)=='+'){
            res[temp][0]="/";
            last='+';
        }else if(c.charAt(0)=='-'){
            res[temp][0]="\\";
            last ='-';
        }else{
            res[temp][0]="-";
            last='=';
        }

        for (int i = 1; i < c.length(); i++) {
            if (c.charAt(i)=='+'){
                if ('+'==last||'='==last){
                    temp--;
                }
                res[temp][i]="/";
                last='+';
            }else if(c.charAt(i)=='-'){
                if ('-'==last){
                    temp++;
                }
                res[temp][i]="\\";
                last='-';
            }else{
                res[temp][i]="-";
                last='=';
            }
        }
        Arrays.stream(res).forEach(k->{
            Arrays.stream(k).forEach(System.out::print);
            System.out.println();
        });

    }
}

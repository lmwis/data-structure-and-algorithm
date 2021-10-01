package bianlifeng;

import java.util.Arrays;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/29 5:23 下午
 * @Version: 1.0
 */
public class Q1 {
    /**
     * 晚的大于早的
     * exp:d1-11.30 d2-14:28 true
     * ---  ------   --
     *  ------ -------
     * -      -       -
     * @return
     */
//    public static boolean isAfter(int[] d1,int [] d2){
//        int i=0,j=0;
//        int index = 0;
//        int[] res = new int[d1.length];
//        int start = d1[0];
//        while(start<=d1[d1.length-1]){
//            if (start<d2[j]){
//                res[index] = start;
//                res[index+1] = d1[j];
//                if (d2[j+1]<d1[i+1]){
//                    start = d2[j+1];
//                }else {
//                    start = d1[i+2];
//                }
//                start = d1[j+1];
//            }else {
//
//            }
//        }
//    }
    public static void main(String[] args) {

        int[] d1 = new int[]{90,120,130,180};
        int[] d2 = new int[]{95,100,180,200};


        int[] res = new int[d1.length*2];
        int index = 0;
        for (int i = 0; i < d1.length; i+=2) {
            for (int j = 0; j < d2.length; j+=2) {
                int[] ints = hasCover(d1[i], d1[i + 1], d2[j], d2[j + 1]);
                if (ints!=null){
                    for (int k = 0; k < ints.length; k++) {
                        res[index++] = ints[k];
                    }
                }
            }
        }
        Arrays.stream(res).forEach(System.out::println);
        
    }

    public static int[] hasCover(int a1,int a2,int b1,int b2){

        // 反向包含
        if (b1<a1&&b2>a2) return null;
        if (a2<=b1 || a1>=b2) return new int[]{a1,a2};
        if ((a1<=b1 && a2>=b2)){ // 包含
            return new int[]{a1,b1,b2,a2};
        }else if(a1>b1 &&a1<b2){ // 左重
            return new int[]{b2,a2};
        }else{ // 右重
            return new int[]{a1,b1};
        }
    }
}

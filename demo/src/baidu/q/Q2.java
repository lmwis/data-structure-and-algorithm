package baidu.q;

import java.util.Scanner;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/7 7:17 下午
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }
        String[] res = method(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    private static String[] method(int n, String[] arr) {
        String[] res = new String[n];
        for(int i=0;i<n;i++){
            // 不是0
            String numStr = arr[i];
            StringBuilder resStr = new StringBuilder();
            boolean flag = false;
            for (int j = numStr.length()-1; j >=0 ; j--) {
                int pos = Integer.parseInt(numStr.charAt(j)+"");
                StringBuilder temp = new StringBuilder();
                if (flag){ // 表示发生过借位
                    if (pos<=1){ // 连环借位
                        if (j==0){
                            break;
                        }
                    }else {
                        pos--;
                    }
                    flag = false;
                }

                if (pos>3){
                    temp.append(3);
                }else if(pos==0){
                    temp.append(3);
                    flag = true;
                }else{
                    temp.append(pos);
                }
                temp.append(resStr);
                resStr = temp;
            }
            res[i] =resStr.toString();
        }
        return res;
    }
}

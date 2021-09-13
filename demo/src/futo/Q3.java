package futo;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/9/12 4:16 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(
                new Q3().chkMixture("AAB",3,"AAC",3,"AAACBA",6));
    }
    public boolean chkMixture(String A, int n, String B, int m, String C, int v) {
        // write code here
        if (v!=(n+m) || v==0) return false;
        int ap = 0;
        int bp = 0;
        for (int i = 0; i < v; i++) {
            if (ap<n&&C.charAt(i)==A.charAt(ap)){
                ap++;
            }else if(bp<m && C.charAt(i)==B.charAt(bp)){
                bp++;
            }else{
                return false;
            }
        }
        return true;
    }
}

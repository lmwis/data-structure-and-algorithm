package shoppe;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/5 4:29 下午
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        System.out.println(new Q3().compressString("aabcccccaa"));
    }
    public String compressString(String param) {
        if (param.length() < 1) return param;
        StringBuffer res = new StringBuffer();
        int count = 1;
        char c = param.charAt(0);
        for (int i = 1; i < param.length(); i++) {
            char cur = param.charAt(i);
            if (c == cur) {
                count++;
            } else {
                res.append(c);
                if(count > 1){
                    res.append(count);
                }
                c = cur;
                count = 1;
            }
        }
        res.append(c);
        if(count > 1){
            res.append(count);
        }
        return res.toString();
    }
}

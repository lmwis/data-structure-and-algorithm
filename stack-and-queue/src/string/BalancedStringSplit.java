package string;

/**
 * @Description: 1221. 分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL"、"RRLL"、"RL"、"RL" ，每个子字符串中都包含相同数量的 'L' 和 'R' 。
 *
 * @Author: lmwis
 * @Data: 2021/9/7 2:03 下午
 * @Version: 1.0
 */
public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int res = 0;
        int rCount = 0;
        int lCount = 0;
        for(int i=0;i<s.length();i++){
            if(lCount > 0 && rCount == lCount){
                res++;
                rCount = 0;
                lCount = 0;
            }
            if(s.charAt(i)=='R'){
                rCount++;
            }else{
                lCount++;
            }
        }
        if(lCount > 0 && rCount == lCount){
            res++;
        }
        return res;
    }
}

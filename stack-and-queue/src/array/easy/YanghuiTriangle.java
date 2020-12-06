package array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @Author: lmwis
 * @Date 2020-12-06 13:40
 * @Version 1.0
 */
public class YanghuiTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0){
            return res;
        }
        // 前两层初始化
        List<Integer> layer1 = new ArrayList<>();
        layer1.add(1);
        res.add(layer1);
        if(numRows==1){
            return res;
        }
        List<Integer> layer2 = new ArrayList<>();
        layer2.add(1);
        layer2.add(1);
        res.add(layer2);
        if(numRows==2){
            return res;
        }
        for(int i=2;i<numRows;i++){
            List<Integer> layer = new ArrayList<>();
            List<Integer> up = res.get(i-1);
            layer.add(1);
            for(int j=0;j<i-1;j++){
                layer.add(up.get(j)+up.get(j+1));
            }
            layer.add(1);
            res.add(layer);
        }
        return res;
    }

}

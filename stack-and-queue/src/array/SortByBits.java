package array;

import java.util.Arrays;

/**
 * @Description: 1356. 根据数字二进制下 1 的数目排序'
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * 示例 1：
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 *
 * @Author: lmwis
 * @Date 2020-11-06 15:51
 * @Version 1.0
 */
public class SortByBits {

    public static void main(String[] args) {
        SortByBits sortByBits = new SortByBits();
        Arrays.stream(sortByBits.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})).forEach(System.out::print);
    }

    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        int[] map = new int[length];

        for(int i=0;i<length;i++){
            map[i] = Integer.bitCount(arr[i])*100000+arr[i];
        }
        Arrays.sort(map);

        for(int i=0;i<map.length;i++){
            map[i] = map[i]%100000;
        }
        return map;

    }
}

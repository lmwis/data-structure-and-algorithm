package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * @Author: lmwis
 * @Date 2020-11-02 10:38
 * @Version 1.0
 */
public class Intersection {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Arrays.stream(intersection.intersection(nums1, nums2)).forEach(k->{
            System.out.print(k+" ");
        });
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i:(nums1.length>nums2.length?nums1:nums2)){
            set.add(i);
        }
        for(int i:(nums1.length<nums2.length?nums1:nums2)){
            if(set.contains(i)){
                res.add(i);
            }
        }
        return Arrays.stream(res.toArray(new Integer[0])).mapToInt(Integer::valueOf).toArray();
    }

}

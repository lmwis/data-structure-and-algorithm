package sort;

/**
 * @Description: 堆排序
 * 时间：
 *  平均：O(nlog2n)
 *  最好：O(nlog2n)
 *  最坏：O(nlog2n)
 * 空间：O(1)
 * 不稳定
 *
 * 1.构造大顶堆，取堆顶数字跟最后一个数字交换
 * 2.再将剩下的数字构造大顶堆，取堆顶数字跟当前最后一个数字交换
 * 3.重复直到取完数字，最终得到从小到大的排序序列
 *
 * 堆化 heapify，从最后一个叶子节点的父节点开始往后进行调整，将当前节点与其的左右叶子节点进行比较，最大的交换为父节点
 *
 * 最后一个叶子节点的父节点计算：(n-1)/2
 * 当前节点的叶子节点：i*2 + 1 (左) i*2 + 2 (右)
 * 当前节点的父节点：(i-1)/2
 * @Author: lmwis
 * @Date 2021-03-05 14:15
 * @Version 1.0
 */
public class HeapSort {
}
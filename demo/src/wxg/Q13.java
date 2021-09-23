package wxg;

/**
 * @Description:
 *
 * 3。 一个页面有两个广告位，现有a/b/c/d这4个广告需要展示，实现一个算法输出需要展示的一对广告
 *     要求：
 *     a.输出的两个广告不能相同；
 *           不可以出现 aa,bb,cc,dd这种组合
 *     b.多次调用输出的四个广告的概率为：1:2:3:4  （4个广告用abcd来表示) = 10
 *          例如输出10000对广告，统计abcd出现的次数接近于 2000:4000:6000:8000次
 *     c.进阶：是否存在通用解，n个广告，概率为p1:p2:...:pn
 *
 *     可以使用随机数生成函数
 *
 *     3 6 9 12 = 30
 *     4 8 12 16
 *     ab ac ad ad 4 1 1 2
 *     bc bc bc bc bd bd bd 0 7 4 3
 *     cd cd cd cd cd cd cd cd cd cd cd cd
 *
 * @Author: lmwis
 * @Data: 2021/9/22 8:52 下午
 * @Version: 1.0
 */
public class Q13 {
}

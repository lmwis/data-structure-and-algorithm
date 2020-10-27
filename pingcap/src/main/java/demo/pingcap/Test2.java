package demo.pingcap;

/**
 * @Description:
 *  两个栈实现带泛型的队列
 *  单元测试
 * @Author: lmwis
 * @Date 2020-10-27 16:19
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.delete());
        System.out.println(queue.delete());
        System.out.println(queue.delete());
        System.out.println(queue.delete());
        queue.add(1);
        queue.add(2);
        System.out.println(queue.delete());
    }
}

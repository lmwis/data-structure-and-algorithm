package easy;

import java.util.Stack;

/**
 * @Description: 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * @Author: lmwis
 * @Data: 2021/11/19 12:02 下午
 * @Version: 1.0
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> descStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        descStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (descStack.isEmpty()||x<=descStack.peek()) descStack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(descStack.peek())){
            descStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return descStack.peek();
    }
}

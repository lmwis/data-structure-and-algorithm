package demo.pingcap;

import java.util.Stack;

/**
 * @Description:
 * @Author: lmwis
 * @Date 2020-10-27 16:21
 * @Version 1.0
 */
public class MyQueue<T> {
    private Stack<T> along = new Stack<>();
    private Stack<T> invert = null;
    public void add(T t){
        along.push(t);
        Stack<T> temp = (Stack<T>) along.clone();
        invert = new Stack<>();
        while(!temp.empty()){
            invert.push(temp.pop());
        }
    }
    public T delete(){
        if(invert!=null && !invert.empty()){
            return invert.pop();
        }
        return null;
    }
}

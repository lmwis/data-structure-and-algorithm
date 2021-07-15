package medium;

import java.util.Stack;

/**
 * @Description: TODO
 * @Author: lmwis
 * @Data: 2021/7/15 11:22 下午
 * @Version: 1.0
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i]>root){ // root左边比root小
                return false;
            }
            while(stack.size()!=0 && stack.peek()>postorder[i]){
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;

    }
}

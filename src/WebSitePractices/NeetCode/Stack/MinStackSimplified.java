package WebSitePractices.NeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStackSimplified {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    //Constructor
    private MinStackSimplified() {
        minStack.push(Integer.MAX_VALUE);
    }

    //push operation
    private void push(int val){
        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }

    //pop operation
    private void pop(){
        stack.pop();
        minStack.pop();
    }

    //peek() or top() operation
    private int top(){
        return stack.peek();
    }

    //getMinimum
    private int getMinimum(){
        return minStack.peek();
    }
}

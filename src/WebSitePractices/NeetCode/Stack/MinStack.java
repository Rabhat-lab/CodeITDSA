package WebSitePractices.NeetCode.Stack;

import java.util.Stack;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) time.
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 * Output: [null,null,null,null,0,null,2,1]
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top();    // return 2
 * minStack.getMin(); // return 1
 * pop, top and getMin will always be called on non-empty stacks.
 * Solution Approach :
 * The solution involves using two stacks to keep track of the minimum element in conjunction with the main stack operations.
 *
 */
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long) val);
            min=val;
        } else {
            stack.push(val-min);
            if(val<min){
                min=val;
            }
        }
    }
    public void pop() {
        long pop = stack.pop();
        if(stack.isEmpty()){
            return;
        }
        if(pop<min){
            min=pop;
        }
    }

    public int top() {
        long top = stack.peek();
        if (top < min) {
            min = top;
        }
        return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}

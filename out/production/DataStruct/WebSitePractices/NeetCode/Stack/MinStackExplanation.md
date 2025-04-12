MinStack - Leetcode 155
------------------------
Problem : Design a stack class that supports the push, pop, top, and getMin operations.

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
Each function should run in O(1) time.

Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]

Output: [null,null,null,null,0,null,2,1]

Explanation:
MinStack minStack = new MinStack();
minStack.push(1);
minStack.push(2);
minStack.push(0);
minStack.getMin(); // return 0
minStack.pop();
minStack.top();    // return 2
minStack.getMin(); // return 1

Explanation :
* This is quite challenging because the standard stack data structure does not keep track of the minimum element,
* and searching for the minimum element typically requires O(n) time where n is the number of elements in the stack.
* To maintain the minimum element information in constant time, we need a strategy that keeps track of the minimum
* at each state of the stack. The solution uses two stacks:
* * The first stack stk1 behaves like a normal stack, holding all the elements.
* * The second stack stk2 keeps track of minimum elements. Each element in stk2
* corresponds to the minimum element of stk1 up to that point.
* With each push, we insert the value into stk1 and also update the stk2 with the minimum of the new value and the
* current minimum, which is the top element of stk2.
* Upon pop, we simply remove the top elements from both stk1 and stk2.
* Given stk2 is always in sync with stk1 but only storing minimums,
* it ensures that stk2's top always represents the current minimum of stk1.
* top is straightforward as we return the top element of stk1 whereas getMin returns the top element of stk2.

Solution :
The solution involves using two stacks to keep track of the minimum element in conjunction 
with the main stack operations.
1. MinStack()  object initialization -> in this operation create 2 stack objects . the first stack to hold the values and
* 2nd stack to store minimum values so far
2. push(int val) -> push the value sent in val to the stack 1 and , maintain the minimum by taking the minimum between the
* entered val and current min and push to the second stack
3. pop() -> pop the element from the stack 1 similarly pop the element from the stack 2
4. top() /peek() -> return the top element of the stack. 
5. getMin() -> return top element of stack 2 
* 

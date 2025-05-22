package DataStructs.NeetCode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * We did BrowserHistory using Linked List
 * Lets see BrowserHistory using stack which is more efficient
 * We can use two stacks to model the back and forward browser functionality
 * The main stack (stk1) keeps track of the browsing history where the top of
 * the stack is the current page being viewed.
 * Another stack (stk2) is used to keep track of the pages that have
 * been gone back from, enabling us to navigate forward.
 *
 * Visit: When visiting a new URL, we push it onto stk1, representing that it is now the current page.
 * We also clear stk2, because visiting a new page after going back in history means that you can no
 * longer go forward to the pages that were ahead of your previous current page
 * (this reflects real browser behavior).
 *
 * Back: When moving back, we pop URLs from stk1 and push them onto stk2,
 * decrementing the steps each time until we either reach the desired number of steps or
 * can't go back further (because we've reached the homepage).
 * The top of stk1 after these operations gives us the current page.
 *
 * Forward: The forward action is similar to back but in reverse —
 * we pop from stk2 and push onto stk1, moving the current page forward in history.
 * Again, we do this until we've completed the desired number of steps or
 * we've reached the most recent page (when stk2 is empty).
 *
 * Solution Approach:
 * Constructor: BrowserHistory(string homepage) ->
 * When a new BrowserHistory object is created, it is initialized with the homepage.
 * This is done by calling the visit method with the homepage URL as the argument,
 * establishing the starting point of our browser history.
 * At this point, stk1 will contain the homepage URL, and stk2 will be empty as
 * there's no forward or backward history.
 *
 * Visit Method: visit(string url)
 * When visiting a new URL, we push the URL onto stk1 (the stack representing our browse history)
 * and clear stk2 (forward history).
 * Clearing stk2 is essential because any forward history is erased as per the real-life browser behavior
 * whenever you visit a new page after navigating back.
 * The current URL is now at the top of stk1.
 *
 * Back Method: back(int steps)
 * This method simulates the action of the 'Back' button in a browser.
 * When invoked, it checks if we can move back the given number of steps.
 * As long as there are more than one URLs in stk1 (we're not at the homepage),
 * it transfers the top URL to stk2 (simulating movement back in history).
 * It reduces steps by 1 each time this transfer happens.
 * Finally, when steps reach zero or cannot go back further, it returns the current URL,
 * which is at the top of stk1.
 *
 * Forward Method: forward(int steps)
 * This method simulates pressing the 'Forward' button in a browser, the reverse of the back method.
 * While there are items in stk2 (i.e., there's forward history to traverse) and steps is not zero,
 * it moves URLs from stk2 back to stk1. This process effectively steps back through the history forward.
 * Once steps have been depleted or there is no more forward history (stk2 is empty),
 * it returns the URL at the top of stk1, which is now the current page.
 *
 * The overall pattern this solution follows is a classic use of stack data structures
 * for managing history in such a way that the order of movement back and forth is naturally maintained.
 * Stacks are ideal because they follow a last-in-first-out (LIFO) principle that directly aligns
 * with the action of navigating backward and forward through a linear browsing history.
 *
 * Example walkthrough in the BrowserHistoryStack.md
 *
 */
public class BrowserHistoryStack {
    //stack1 for keeping the history of browsers
    Deque<String> stack1 = new ArrayDeque<>();
    Deque<String> stack2 = new ArrayDeque<>();

    public BrowserHistoryStack(String homepage){
        visit(homepage);
        System.out.println("Visited page "+homepage);
    }
    public void visit(String url){
        stack1.push(url);
        stack2.clear(); // clear forward navigation
    }

    public String back(int steps){
        if(steps >0 && stack1.size()>1){
            stack2.push(stack1.pop());
            steps--;
        }
        System.out.println("Page back :"+stack1.peek());
        return stack1.peek();
    }

    public String forward(int steps){
        if(steps >0 && !stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        System.out.println("Page Forward :"+stack1.peek());
        return stack1.peek();
    }

    public static void main(String[] args){
        BrowserHistoryStack b = new BrowserHistoryStack("leetcode.com");
        b.visit("google.com");
        b.visit("facebook.com");
        String backPage = b.back(1);
        System.out.println(backPage);
        String forwardPage = b.forward(1);
        System.out.println(forwardPage);
        b.visit("youtube.com");
        forwardPage = b.forward(2);
        System.out.println(forwardPage);
    }

}

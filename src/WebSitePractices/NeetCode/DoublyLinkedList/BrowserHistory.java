package WebSitePractices.NeetCode.DoublyLinkedList;

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 * Implement the BrowserHistory class:
 * 1. BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * 2. void visit(string url) Visits url from the current page. It clears up all the forward history.
 * 3. string back(int steps) Move steps back in history. If you can only return x steps in the history
 * and steps > x,you will return only x steps. Return the current url after moving back in
 * history at most steps.
 * 4. string forward(int steps) Move steps forward in history.
 * If you can only forward x steps in the history and steps > x, you will forward only x steps.
 * Return the current url after forwarding in history at most steps.
 *  note : this can also be solved using a stack / dynamic array which is more efficient way of solving
 *  this problem. with dynamic array or stack this problem will come down to O(1)
 *
 * Your BrowserHistory object will be instantiated and called as such:
 *  * BrowserHistory obj = new BrowserHistory(homepage);
 *  * obj.visit(url);
 *  * String param_2 = obj.back(steps);
 *  * String param_3 = obj.forward(steps);
 *
 *  Steps to solve
 * 1. To solve the problem, we will be using a doubly-linked list.
 * We do so because, in a doubly-linked list, backward and forward movement
 * can be easily implemented, and creating the linked list can be done in linear time.
 * 3. Create a constructor for our linked list. Here, we have named our linked list Site.
 * It has three attributes- prv(Site), next(Site), url(String).
 * 4. Initialize the nodes of Site with the incoming urls.
 * 5. Now come to the class BrowserHistory. Create a new doubly linked list.
 * In our solution code, we named it curr.
 * 6. As per the problem statement, class BrowserHistory has four member functions.
 * Their uses and implementation are as follows:
 * 7. BrowserHistory(string homepage): initialize the homepage with the incoming string value.
 * This is our fixed homepage and will not be changed.
 * 8. void visit(String url): visit the given url. By visiting the url, we mean to create a new node;
 * the url of this node will be the incoming url, that is, curr.next is the url of the new node.
 * Link this node to the previous nodes.
 * 9. String back(int steps): travel back steps number of nodes.
 * We try to traverse our linked list as long as the curr.prv value
 * is not null and steps-- is not zero. We return the url of the destination node.
 * 10. String forward(int steps): travel forward steps number of nodes.
 * We try to traverse our linked list as long as the curr.next value is not null
 * and steps-- is not zero. We return the url of the destination node.
 * 11. To run the code, create a class BrowserImplement and create a main() method.
 * 12. Inside the main() method, create a new linked list object of the type BrowserHistory
 * and call the functions as per your requirements.
 */
class Site {
    String val;
    Site next;
    Site prev;
    public Site(String val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    public Site(String val,Site next,Site prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class BrowserHistoryOps {
    Site browserHead ;

    public BrowserHistoryOps(String homepage) {
        browserHead = new Site(homepage);
    }

    public void visit(String url) {
        browserHead.next = new Site(url);
        browserHead.next.prev = browserHead;
        browserHead = browserHead.next;
        System.out.println("visited url is "+url);

    }
    public String back(int steps) {
        while(browserHead !=null && steps-- >0){
            browserHead = browserHead.prev;
        }
        System.out.println("Browser is at :"+browserHead.val+" after moving "+steps+" back");
        return browserHead.val;
    }
    public String forward(int steps) {
        while(browserHead!=null && steps-- >0){
            browserHead = browserHead.next;
        }
        System.out.println("Browser is at :"+browserHead.val+" after moving "+steps+" forward");
        return browserHead.val;
    }
}

public class BrowserHistory {
    public static void main(String[] args){
        BrowserHistoryOps ops = new BrowserHistoryOps("google.com");
        ops.visit("geeks.com");
        ops.visit("leetcode.com");
        ops.visit("neetcode.com");

        String step_back = ops.back(1);
        System.out.println("Redirected back to: "+step_back);

        String step_fwd = ops.forward(1);
        System.out.println("Redirected fwd to: "+step_fwd);
    }

}

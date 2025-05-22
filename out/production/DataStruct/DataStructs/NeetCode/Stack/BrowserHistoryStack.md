Example Walkthrough of BrowserHistoryStack
------------------------------------------------
Let's take an example to illustrate how the BrowserHistory class and its methods work in practice:

Suppose we initialize the browser history with the homepage:
browserHistory = BrowserHistory("leetcode.com")
After this step, stk1 contains ["leetcode.com"] and stk2 is empty.

We visit a new URL "google.com":
browserHistory.visit("google.com")
stk1 is now ["leetcode.com", "google.com"], and stk2 remains empty, as visiting a new URL doesn't involve moving back or forward.

Let's visit another URL "facebook.com":
browserHistory.visit("facebook.com")
Now, stk1 has ["leetcode.com", "google.com", "facebook.com"], and stk2 is still empty.

We decide to move back by 1 step in the history:
current_url = browserHistory.back(1)
This transfers "facebook.com" from stk1 to stk2, leaving us with stk1 = ["leetcode.com", "google.com"] 
and stk2 = ["facebook.com"]. The current_url is "google.com".

We move back again, this time by 2 steps:
current_url = browserHistory.back(2)
We can only move back by 1 step because we're at "google.com" and can't go further back than "leetcode.com", so stk1 becomes ["leetcode.com"] and stk2 transforms to ["google.com", "facebook.com"]. The current_url is "leetcode.com".

Now we move forward by 1 step:
current_url = browserHistory.forward(1)
"google.com" is popped from stk2 and pushed onto stk1, resulting in stk1 = ["leetcode.com", "google.com"]
and stk2 = ["facebook.com"]. The current_url becomes "google.com".

If we visit a new site "youtube.com":
browserHistory.visit("youtube.com")
stk1 becomes ["leetcode.com", "google.com", "youtube.com"] and stk2 is cleared out, 
signifying that the forward history is erased due to this new visit. stk2 = [].

Finally, if we try to go forward by 2 steps:
current_url = browserHistory.forward(2)
We can't move forward because stk2 is empty, hence the current_url remains "youtube.com".

So our final stacks look like this: stk1 = ["leetcode.com", "google.com", "youtube.com"] 
and stk2 = []. This series of actions demonstrates how the methods work together to simulate 
real-world browser history navigation.
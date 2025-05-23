Leetcode 347: Top K frequent elements
--------------------------------------
Question:
-----------
* Given an integer array nums and an integer k, return the k most frequent elements within the array.
* The test cases are generated such that the answer is always unique.
* You may return the output in any order.

Examples:
-----------
Example 1:
Input: nums = [1,2,2,3,3,3], k = 2
Output: [2,3]

Example 2:
Input: nums = [7,7], k = 1
Output: [7]

Approach:
---------
* what does the question say ? need to find the most frequent elements in the array
* How can we think this can be done ? Brute force approach would be to have a hashmap 
* which is having frequency of each element in the array and then extract the highest two elements with
* maximum frequency.
* other approach is using the priority queue minHeap
* 
* using Hashmap approach:
* 1.The most straightforward way to find the top k frequent elements is to count the frequency 
* 2.of each element using a hashmap, then sort the elements based on their frequency in descending 
* 3.order, and finally pick the first k elements from this sorted list.
* 4.Create a hashmap to count the frequency of each element.
* 5.Transform hashmap entries into a list of pairs and sort it based on frequency.
* 6.Extract the first k elements from the sorted list.
* 
* using minHeap approach:
* 1.Instead of sorting all elements, we can use a Min-Heap (Priority Queue) to keep track of 
* 2.the top k elements. As we iterate through the hashmap, we maintain the size of the heap to 
* 3.be at most k by removing the smallest element whenever the size exceeds k.
* 4.Use a hashmap to count the frequency of each element.
* 5.Use a priority queue to keep track of the top k elements.
* 6.Iterate through the map and push each entry into the Min-Heap,evicting the smallest when the heap exceeds size k.
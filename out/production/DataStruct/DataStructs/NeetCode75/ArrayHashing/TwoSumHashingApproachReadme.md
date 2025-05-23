LeetCode - 1 - Two Sum
----------------
Question
-----------
Given an array of integers nums and an integer target, return indices of the 
two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Examples
------------
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Approach
----------
* This is a classic two sum problem which does not sort the arrays unlike in the two pointers two sum question.
* The question says that we have to find the two integers in the given array which sum upto the given target
* The Brute force approach for this would be to traverse through the array with one outer loop and one inner loop
adding each elements and verifying if this would form a target value.
* This would take significant time as it involves multiple iterations
* So, to overcome this what can be done ?
* if we use 2 pointers we might fail in some cases like {-10,-1,-18,-19} where the while loop condition might fail
* so one of the ways to achieve this is using HashMap.
* Why HashMap? we need to find distinct elements and we use hashmap so that we can store the index of that elements as well
* how to solve ? 
* 1.Create a hashmap which will store the values that sums up to the target value
* 2.now start traversing over the array.
* 3.the first element will be the current element in the hashmap 
* 4.the second element should be the element got from subtracting the target value with the first element
* 5.if that element id present in array then we return the indices of the numbers
* 6.keep in mind in the given array there can exist only 1 pair that can satisfy the condition and do not repeat the numbers
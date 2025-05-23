LeetCode-217-Contains Duplicate
--------------------------------
Question : 
----------
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Examples:
------------
Example 1:
Input: nums = [1,2,3,1]
Output: true 
Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false 
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Approach:
------------
* What does the question say ? -> It says that if the elements in the array repeats then the array contains duplicates
* for this we need to output as "true"
* How to approach this problem ? -> As brute force method we can think of having two iterations which 
* will loop over . one external iteration and one internal iteration.
* the external iteration will start with one key and the internal iteration will traverse for the next consecutive elements
* finding if they are the same and then increment the external iteration for the next element
* if we think of this brute force approach the time that might be taken to finish this job is very high as 
* it has to iterate over all the elements comparing with the other elements
* So how to make this solution more efficient now without needing to traverse so much ?
* for this lets look back to the question, the question says distinct elements . when the word distinct comes 
* into picture the first data structure that comes in to the mind is the Set which holds the distinct elements
* now iterate over the array and check if the set contains the element of the array. 
* if the set contains the element of the array then containsDuplicate will be set true.


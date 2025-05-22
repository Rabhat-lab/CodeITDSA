Leetcode - 27 - Remove element equal to value
----------------------------------------------
Question:
* Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
* The order of the elements may be changed. Then return the number of elements in nums which are
* not equal to val.
* Consider the number of elements in nums which are not equal to val be k,
* to get accepted, you need to do the following things:
* * Change the array nums such that the first k elements of nums contain the
* elements which are not equal to val. The remaining elements of nums are not important
* as well as the size of nums.
* Return k.

Examples:
* 
* Input: nums = [3,2,2,3], val = 3
* Output: 2, nums = [2,2,_,_]
* Explanation: Your function should return k = 2, with the first two elements of nums being 2.
* It does not matter what you leave beyond the returned k (hence they are underscores).

Approach:
1.Create a method to call from the main method which will return the remaining elements which are not equal to
the target value.
2.iterate over the array 
3.check if the value in the iteration not equals the target value
4.if its not equal then add the element to the a[count++]

Step by step iteration logic:
* 1. i=0;  
* 2. i=1;
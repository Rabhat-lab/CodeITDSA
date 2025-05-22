LeetCode - 26 : Remove Duplicates from Sorted Array
-----------------------------------------------------
Question:
Given an integer array nums sorted in non-decreasing order,
* remove the duplicates in-place such that each unique element appears only once.
* The relative order of the elements should be kept the same.
* Then return the number of unique elements in nums.
* Consider the number of unique elements of nums to be k,
* to get accepted, you need to do the following things:
* * Change the array nums such that the first k elements of nums contain the
* unique elements in the order they were present in nums initially.
* The remaining elements of nums are not important as well as the size of nums.
* * Return k.

Examples :
* Input: nums = [1,1,2]
* Output: 2, nums = [1,2,_]
* Explanation: Your function should return k = 2,
* with the first two elements of nums being 1 and 2 respectively.
* It does not matter what you leave beyond the returned k (hence they are underscores).
* 
* Input: nums = [0,0,1,1,1,2,2,3,3,4]
* Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
* Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
* It does not matter what you leave beyond the returned k (hence they are underscores).

Approach :
* 1. Take an integer i which will be the result returned and initialize it to 0
* 2. now take the for loop starting with j=1 till the length of the array
* 3. if the element at ith position is not equal to element in the jth position
* 4. then increment the i and put the element in the jth position to the ith position
* 5. continue the iteration
* 
Step by step iteration logic:
* 1. i=0; j=1 ; a[i]!=a[j]? -> a[0] !=a[1]? = 2!=10? = true ; i++ : i=1; a[i]=a[j] -> a[1]=a[1]
* 2. i=1; j=2; a[i]!=a[j]? -> a[1] != a[2]?= 10!=10? = false ;
* 3. i=1; j=3; a[i]!=a[j]? -> a[1] != a[3]?= 10!=30? = true ; i++: i=2; a[i]=a[j] -> a[2]=a[3]
* 4. i=2; j=4; a[i]!=a[j]? -> a[2] != a[4]?= 30!=30? = false;
* 5. i=2; j=5; a[i]!=a[j]? -> a[2] != a[5]?= 30!=30? = false;
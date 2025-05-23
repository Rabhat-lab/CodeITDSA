LeetCode - 242 - Valid Anagram
-------------------------------
Question:
---------
Given two strings s and t, return true if the two strings are anagrams of each other otherwise return false.

Example:
----------
An anagram is a string that contains the exact same characters as another string,but the order of the characters can be different.
Example 1:
* Input: s = "racecar", t = "carrace"
* Output: true

Example 2:
* Input: s = "jar", t = "jam"
* Output: false

Approach:
---------
* What does the question say ? The question says if the two strings form a valid anagrams meaning it has same characters same as the input string
* What are the constraints that it has to be an anagram ? -> it should be same length as the input string, the strings
* should have same characters as that of the input string
* How do we do this ? Brute force approach can be converting the string1 and string2 into character array and comparing each character to each other to check if they are present
* to do this we again need to have 2 for loops and this can be time consuming approach
* so how do we do this ? -> if you think each character in a string has an ascii value
* so we can take an array and get the count of the letter and then increment the array
* then when it comes to the target string repeat the same and decrement the array 
* if the two strings have all the characters mentioned then it will become 0
* else it will have some value , if it has some value then we have to return false else if the 
* array has become 0 then return true.
LeetCode - 49
-------------------
Question:
----------
* Given an array of strings strs, 
* group all anagrams together into sublists. You may return the output in any order.
* An anagram is a string that contains the exact same characters as another string, 
* but the order of the characters can be different.

Examples:
------------
Example 1:
Input: strs = ["act","pots","tops","cat","stop","hat"]
Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

Example 2:
Input: strs = ["x"]
Output: [["x"]]

Example 3:
Input: strs = [""]
Output: [[""]]

Approach :
-----------
* What is the question saying ? The question is asking to group the anagrams together , meaning the words which are
* anagram of each other have to be grouped together
* how to do this ? when we think one of the brute force method to do this would be to take an external loop
* which traverses over the string array , take each word of the array convert it into character array
* then compare with each other and find if other words have the same characters .
* if we do this way what will happen is not only the words we will also take the letters and need to traverse
* with the letters increasing the complexity
* so how do we solve this ? we can create a map which has a string as key and list of anagrams as the values.
* what are the steps ? 1. create a hashmap with string as key and list of strings as values
* 2.now have an iteration started with each string in the string array
* 3.convert the input string to a char array and sort this array 
* 4.now create a string out of the sorted char array
* 5.now use computeIfAbsent of Map which check if the sorted value is already associated with the value
* 6.else compute the value and return the values of the map
* 

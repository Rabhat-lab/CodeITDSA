package NeetCodePattern.ArraysString.SlidingWindow.Variable;

import java.util.HashSet;

/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "zxyzxyz"
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 *
 * Example 2:
 * Input: s = "xxxx"
 * Output: 1
 */
public class LongestSubStrWithoutRepChars {
    public static void main(String[] args){
        String s = "zxyzxyz";
        int maxLen = getLongestSubStrWithoutRepChars(s);
        System.out.println(maxLen);
    }
    private static int getLongestSubStrWithoutRepChars(String s){
        int left=0,maxLen =0, len = s.length();
        //declare a hashset to maintain the distinct characters
        HashSet<Character> set = new HashSet<>();

        //iterate
        for(int right=0;right<len;right++){
            //if the duplicate is found shrink by removing the left character
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            //add the characters from the right to the set
            set.add(s.charAt(right));
            maxLen = Math.max(right-left+1,maxLen);
        }
        return maxLen;
    }
}

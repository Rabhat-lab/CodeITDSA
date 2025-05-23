package DataStructs.NeetCode75.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
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
 *
 */
public class LongestSubStrNoRepeatChar {
    public static void main(String[] args){
        String s = "zxyzxyz";
        int substrlen = getLongSubStrWithoutRepeatChar(s);
        System.out.println(substrlen);
    }
    private static int getLongSubStrWithoutRepeatChar(String s){
        int substrLen=0; //intialize an length variable to 0
        Set<Character> scharSet = new HashSet<>(); // take a hashset which will hold the unique elements
        int i=0,j=0; //take two pointers i and j
        int len=s.length(); // find the length of the string

        while(i<len && j<len){ //while loop when the pointers are less than the length
            if(!scharSet.contains(s.charAt(j))){ //if the set does not contain the character at jth index
                scharSet.add(s.charAt(j)); // we add that character to the set
                j++; // increment the j
                substrLen= Math.max(substrLen,j-i); //find the substring length and max between existing substring and j-i index
            } else {
                scharSet.remove(s.charAt(i)); //else the character are repeated and hence remove it from the set
                i++; // increment the i index
            }
        }
        return substrLen;
    }
}

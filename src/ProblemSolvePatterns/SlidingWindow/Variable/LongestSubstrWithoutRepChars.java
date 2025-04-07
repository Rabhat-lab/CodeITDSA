package ProblemSolvePatterns.SlidingWindow.Variable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 */
public class LongestSubstrWithoutRepChars {
    public static void main(String[] args){
        String s = "abcabcbb";
        int l = getLongestSubstr(s);
        System.out.println(l);
    }

    private static int getLongestSubstr(String s){
        Set<Character> a = new HashSet<>();
        int i=0;
        int j=0;
        int n = s.length();
        int len = 0;
        while(i<n && j<n){
            if(!a.contains(s.charAt(j))){
                a.add(s.charAt(j));
                j++;
                len = Math.max(len,j-i);
            } else {
                a.remove(s.charAt(i));
                i++;
            }
        }
        return len;
    }
}

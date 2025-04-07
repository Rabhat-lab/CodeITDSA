package ProblemSolvePatterns.SlidingWindow.Fixed;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the
 * start indices of p's anagrams in s. You may return the answer in any order.
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Idea :
 * The idea is to maintain two frequency maps:
 * One for the characters in the string p.
 * Another for characters in the current window of s with the same length as p.
 * By sliding the window across s, we compare the frequency of characters in the
 * current window to those in p. If they match, then the start index of this window is
 * an anagram's starting point.
 */
public class AllAnagramsInString {
    public static void main(String[] args){
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> a = getAnagramIndices(s,p);
        for(int x:a){
            System.out.print(","+x);
        }
    }
    private static List<Integer> getAnagramIndices(String s, String p){
        List<Integer> a = new ArrayList<>();
        if(s.length()<p.length()){
           return a;
        }
        //lets take two arrays to count the frequency of characters
        // which is max length of 26 to fit in all the characters
        int[] sCount= new int[26];
        int[] pCount= new int[26];

        //initialize the frequency of the chars
        for(int i=0;i<p.length();i++){
            pCount[p.charAt(i)-'a']++;
            sCount[s.charAt(i)-'a']++;
        }

        //sliding window
return a;
    }
}

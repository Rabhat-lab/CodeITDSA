package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode -438 : All Anagrams in a string
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 *
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class AllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> indexList = getIndexList(s, p);
        System.out.println(indexList);
    }

    private static List<Integer> getIndexList(String s, String p) {
        //take an arraylist which reperesents the result
        List<Integer> anagramCount = new ArrayList<>();
        //if string length is less than the target length then return the target
        if (s.length() < p.length()) {
            return anagramCount;
        }
        //now initialize two arrays which will one count for chars in s and one for c
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        //get the frequency of characters in s string and p string
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        //sliding window over s
        for(int i=0;i<=s.length()-p.length();i++){
            //check if the existing window is an anagram
            if(areArraysEqual(sCount,pCount)){
                anagramCount.add(i);
            }
            //slide the window
            if(i+p.length() < s.length()){
                //remove the old character
                sCount[s.charAt(i)-'a']--;
                //add the new character
                sCount[s.charAt(i+p.length())-'a']++;
            }
        }
        return anagramCount;
    }

    private static boolean areArraysEqual(int[] a, int[] b) {
        for(int i=0;i<a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}

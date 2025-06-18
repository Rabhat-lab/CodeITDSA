package NeetCodePattern.ArraysString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 151 : Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words
 * to a single space in the reversed string.
 *
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "a good   example";
        String revS = getReversedSentence(s);
        String revS1 = getReversedSentenceOptimal(s);
        String revS2 = getReversedSentenceCollection(s);
        System.out.println(revS);
        System.out.println(revS1);
        System.out.println(revS2);
    }
    private static String getReversedSentence(String s){
        String[] words = s.trim().split("\\s+");
        int i=0,j=words.length-1;
        while(i<j){
            String temp = words[i];
            words[i]=words[j];
            words[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",words);
    }
    private static String getReversedSentenceCollection(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> wordrev =  Arrays.asList(words);
        Collections.reverse(wordrev);
        return String.join(" ",wordrev);
    }

    private static String getReversedSentenceOptimal(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            sb.append(words[i]);
            if(i>0) sb.append(" ");
        }
        return sb.toString().trim();
    }
}

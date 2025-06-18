package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

import java.util.*;

/**
 * Leetcode : 30
 * You are given a string s and an array of strings words.
 * All the strings of words are of the same length.
 * A concatenated string is a string that exactly contains all the strings of
 * any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"],
 * then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab"
 * are all concatenated strings. "acdbef" is not a concatenated string because
 * it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"]
 * which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"]
 * which is a permutation of words.
 *
 * Example 2:
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Explanation:
 * There is no concatenated substring.
 *
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 * Explanation:
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 *
 * Brute force approach :
 * Simplest way is to generate all the substrings of desired length and find out if the substring contains
 * for each substring we need to check if the substring forms a valid concatenation of the words.
 * Steps :
 * 1. calculate the total length of all words combined
 * 2. iterate over each substring s of the length we found in step 1
 * 3. for each substring generate all the permutations of the word list
 * 4. check if the permutation match the substring
 * 5. if match is found find the indices of the substring
 *
 * Sliding window Approach:
 * instead of generating permutations we can use sliding window with help of hashmap to keep track of word count.
 * this helps us to efficiently check if the sliding window contains the valid combinations of the words
 * Steps:
 * 1. create a hashmap wordcount containing the frequency of each word
 * 2. iterate over the string s in sliding window where the step is word length
 * 3. for each starting position,initialize a new hashmap seenwords to count words in current window
 * 4. slide over the segment counting words and if the window is invalid (ie word is missing , or we have too many
 * word) reset and start from next word boundary
 * 5. if window is valid add the starting index to result
 *
 *
 */
public class SubStrWIthConcatOfAllStrs {
    public static void main(String[] args){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> a = getIndicesOfConcatSubArr(s,words);
        System.out.println(a);
    }

    private static List<Integer> getIndicesOfConcatSubArr(String s, String[] words) {
        List<Integer>  indexList = new ArrayList<>();
        //find the single word length
        //since the question has mentioned that all the words in the words array are of same length
        int wordLen = words[0].length();
        //find the total length
        int totalWordLen = wordLen*words.length;

        //create a hashmap wordCount
        Map<String,Integer> wordCount = new HashMap<>();
        for(String word:words){
            wordCount.put(word,wordCount.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordLen;i++){
            int left = i,count=0;
            Map<String,Integer> seenWords = new HashMap<>();
            for(int right=left;right<=s.length()-wordLen;right+=wordLen){
                String word = s.substring(right,right+wordLen);
                if(wordCount.containsKey(word)){
                    seenWords.put(word, seenWords.getOrDefault(word,0)+1);
                    count++;
                    while(seenWords.get(word)>wordCount.get(word)){
                        String leftWord = s.substring(left,left+wordLen);
                        seenWords.put(leftWord,seenWords.get(leftWord)-1);
                        count--;
                        left+=wordLen;
                    }
                    if(count==words.length){
                        indexList.add(left);
                    }
                }else {
                    left = right+wordLen;
                    seenWords.clear();
                    count=0;
                }
            }
        }
        return indexList;
    }
}

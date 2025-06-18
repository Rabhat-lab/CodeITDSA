package NeetCodePattern.ArraysString.SlidingWindow.Variable;

/**
 * You are given a string s consisting of only uppercase english characters and an integer k.
 * You can choose up to k characters of the string and replace them with any other uppercase
 * English character.
 * After performing at most k replacements, return the length of the longest substring which
 * contains only one distinct character.
 *
 * Example 1:
 * Input: s = "XYYX", k = 2
 * Output: 4
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 *
 * Example 2:
 * Input: s = "AAABABB", k = 1
 * Output: 5
 *
 * Hint 1
 * Which characters would you replace in a string to make all its characters unique?
 * Can you think with respect to the frequency of the characters?
 *
 * Hint 2
 * It is always optimal to replace characters with the most frequent character in the string.
 * Why? Because using the most frequent character minimizes the number of replacements required
 * to make all characters in the string identical. How can you find the number of replacements now?
 *
 * Hint 3
 * The number of replacements is equal to the difference between the length of the string and the
 * frequency of the most frequent character in the string. A brute force solution would be to
 * consider all substrings, use a hash map for frequency counting, and return the maximum length
 * of the substring that has at most k replacements. This would be an O(n^2) solution. Can you
 * think of a better way?
 *
 * Hint 4
 * We can use the sliding window approach. The window size will be dynamic,
 * and we will shrink the window when the number of replacements exceeds k.
 * The result will be the maximum window size observed at each iteration.
 *
 */
public class LongestRepCharReplace {
    public static void main(String[] args){
        String s = "XYYX";
        int k = 2;
        int maxLen = getLngstSubArrWith1Char(s,k);
        System.out.println(maxLen);
    }
    private static int getLngstSubArrWith1Char(String s,int k){
        //here we use a hashmap to keep the frequency of each string
        //trick to maintain a window where we can replace at most k characters
        //if the window has more than k characters to replace then we shrink the window from the left
        //Steps:
        //1.intialize 2 pointers left,right and a hashmap to hold the character and its frequency
        //2.expand window by moving the right pointer
        //3.calculate max frequency of any character in the current window
        //4.if(windowsize-maxfrequencycharcount which is number of replacements) is greater than k
        //then we shrink the window
        //5.continue till we reach end of string

        int left=0,maxCount=0,maxLen=0;
        int[] count = new int[26];
        //iterate
        for (int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

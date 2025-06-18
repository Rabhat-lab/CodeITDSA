package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * same exact logic as AllAnagramsInString
 *
 */
public class AllPermutationInString {
    public static void main(String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean isPermutation = checkPermutation(s1,s2);
        System.out.println(isPermutation);
    }
    private static boolean checkPermutation(String s1,String s2){
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len){
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i=0;i<s1Len;i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<s2Len-s1Len;i++){
            if(s1IsMatches(s1Count,s2Count)){
                return true;
            }
            //remove the old character
            s2Count[s2.charAt(i)-'a']--;
            //add the next character
            s2Count[s2.charAt(i+s1Len)-'a']++;
        }
        return s1IsMatches(s1Count,s2Count);
    }

    private static boolean s1IsMatches(int[] s1Count, int[] s2Count) {
        for(int i=0;i<s1Count.length;i++){
            if(s1Count[i] != s2Count[i]){
                return false;
            }
        }
        return true;
    }
}

package DataStructs.NeetCode75.ArrayHashing;

/**
 * LeetCode - 242 - Valid Anagram
 * Given two strings s and t, return true if the two strings are anagrams of each other,
 * otherwise return false.
 * An anagram is a string that contains the exact same characters as another string,
 * but the order of the characters can be different.
 *
 * Example 1:
 * Input: s = "racecar", t = "carrace"
 * Output: true
 *
 * Example 2:
 * Input: s = "jar", t = "jam"
 * Output: false
 *
 */
public class ValidAnagram {
    public static void main(String[] args){
        String s = "jar";
        String t = "jam";
        System.out.println(isValidAnagram(s,t));
    }
    private static boolean isValidAnagram(String s,String t){
        //for it to be valid anagram the length of the strings should be same
        if(s.length()!=t.length()){
            return false;
        }
        int[] letterCount = new int[26];
        for(int i=0;i<s.length();i++){
            letterCount[s.charAt(i)-'a']++;
            letterCount[t.charAt(i)-'a']--;
        }
        for(int count:letterCount){
            if(count!=0){
                return false;
            }
        }
        return true;
    }
}

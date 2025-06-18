package NeetCodePattern.ArraysString.TwoPointers;

/**
 * A palindrome is a string that reads the same forward and backward.
 * It is also case-insensitive and ignores all non-alphanumeric characters.
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 *
 * Example 1:
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 * Explanation: After considering only alphanumerical characters we have
 * "wasitacaroracatisaw", which is a palindrome.
 *
 * Example 2:
 * Input: s = "tab a cat"
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 */
public class ValidPallindrome {
    public static void main(String[] args){
        String s = "tab a cat";
        System.out.println(isValidPallindrome(s));
    }
    private static boolean isValidPallindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            } else if(!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            } else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

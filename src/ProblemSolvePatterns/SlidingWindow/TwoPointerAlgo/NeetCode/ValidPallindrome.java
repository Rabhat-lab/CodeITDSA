package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.NeetCode;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward.
 * It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 *
 * Input: s = "tab a cat"
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s is made up of only printable ASCII characters.
 */
public class ValidPallindrome {
    public static void main(String args[]){
        String s = "Was it a car or a cat I saw?";
        boolean b = isValidPallindrome(s);
        System.out.println("is pallindrome: "+b);
    }
    private static boolean isValidPallindrome(String s){
        int i=0;
        int j= s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){i++;}
            else if(!Character.isLetterOrDigit(s.charAt(j))){j--;}
             else if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            } else {
                 return false;
            }
        }
        return true;
    }
}

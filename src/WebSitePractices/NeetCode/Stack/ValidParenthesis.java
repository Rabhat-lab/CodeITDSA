package WebSitePractices.NeetCode.Stack;

import java.util.*;

/**
 * You are given a string s consisting of the following characters:
 * '(', ')', '{', '}', '[' and ']'.
 * The input string s is valid if and only if:
 * Every open bracket is closed by the same type of close bracket.
 * Open brackets are closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Return true if s is a valid string, and false otherwise.
 *
 * Input: s = "[]"
 * Output: true
 *
 * Input: s = "[(])"
 * Output: false
 *
 * Approach :
 * Here we have to take each opening bracket and see if there is a closing bracket for the same
 * 1. create an empty stack - since we dont know the capacity of the stack we consider a list/ArrayDeque as its faster to address this
 * 2. now traverse over the string . each time an opening bracket is met , push it to the stack
 * 3. create an set which has the pairs defined : '{}','[]','()'
 * 4. while traversing the string , if a closed bracket is encountered . pop the element from the stack ,
 * append it with the closed bracket and compare with the set to check if they form a pair
 *
 */
public class ValidParenthesis {
    public static void main(String[] args){
        String s ="[(])";
        boolean isValidParenthesis = chkValidParenthesis(s);
        System.out.println("is valid parenthesis ? "+isValidParenthesis);
    }

    private static boolean chkValidParenthesis(String s){
        Deque<Character> stack = new ArrayDeque<>();
        char[] c= s.toCharArray();
        for(int i=0;i<c.length;i++){
            boolean isCharOpeningBracket = c[i]=='{' || c[i]=='[' || c[i]=='(';
            if(isCharOpeningBracket){
                stack.push(c[i]);
            } else {
                //check if the stack is empty or the match is found or not
                if(stack.isEmpty() || !bracketMatch(stack.pop(),c[i])){
                    return false;
                }
            }
        }
        //After all the pops if the stack is empty then there are valid matches found.
        //else there are brackets still present which did not get a pair
        return stack.isEmpty();
    }

    private static boolean bracketMatch(char pop, char charAt) {
        //check if there is open and matching closing bracket
        return ( pop=='(' && charAt==')' ||
                pop=='[' && charAt==']' ||
                pop=='{' && charAt=='}');
    }
}

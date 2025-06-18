package NeetCodePattern.ArraysString.KadanesAlgo;

/**
 * Leetcode - 978
 * You are given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in
 * the subarray.More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be
 * turbulent if and only if:
 *
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 *
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 *
 * Example 1:
 * Input: arr = [2,4,3,2,2,5,1,4]
 * Output: 4
 * Explanation: The longest turbulent subarray is [2,5,1,4].
 *
 * Example 2:
 * Input: arr = [1,1,2]
 * Output: 2
 *
 * what is a turbulant array :
 * any adjacent values in an array can have 3 relations : greater than, less than, equal to
 * all we have to do is return the length of the subarray such that we have alternating equality signs
 * between the elements
 * for equality we dont consider here as this problem only defines on the
 * greater and lesser alternatively present : [9,4,2,10,7,8,8,1,9] -> [9>4>2<10>7<8=8>1<9]
 * turbulent array with max length is 5 ; 4,2,10,7,8
 *
 * can use sliding window for this
 *
 */

public class LongestTurbulentSubArr {
    public static void main(String[] args){
        int[] a={100};
        int maxLenTurbulentSubArr = getLongetTurbulentSubArr(a);
        System.out.println(maxLenTurbulentSubArr);
    }
    private static int getLongetTurbulentSubArr(int[] a) {
        int left = 0;
        int right = 1;
        int maxLen = 1; //taking 1 element subarray initially
        String prev = "";

        while(right<a.length){
            if(a[right-1] > a[right] && !prev.equals(">")){
                maxLen = Math.max(maxLen,right-left+1);
                right++;
                prev = ">";
            } else if (a[right-1] < a[right] && !prev.equals("<")){
                maxLen = Math.max(maxLen,right-left+1);
                right++;
                prev = "<";
            } else {
                right = (a[right - 1] == a[right]) ? right + 1 : right;
                left = right - 1;
                prev = "";
            }
        }
        return maxLen;
    }
}

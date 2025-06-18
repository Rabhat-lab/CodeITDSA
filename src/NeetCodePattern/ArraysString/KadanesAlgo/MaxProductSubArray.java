package NeetCodePattern.ArraysString.KadanesAlgo;

/**
 * LeetCode - 152
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 */
public class MaxProductSubArray {
    public static void main(String[] args){
        int[] a = {-2};
        int maxProduct = getMaxProductSubArray(a);
        System.out.println(maxProduct);
    }
    private static int getMaxProductSubArray(int[] a){
        //initialize the currentMaxProduct , currentMinProduct and maxProduct to first element in array
        //minProduct is needed because a negative number can change a very big positive number to negative
        //iterate the array starting from 2nd element
        int maxProduct = a[0];
        int minProduct = a[0];
        int maxSubArrProduct = a[0];
        for(int i=1;i<a.length;i++){
            int currentMaxProduct = maxProduct;
            int currentMinProduct = minProduct;
            maxProduct = Math.max(a[i],Math.max(currentMaxProduct*a[i],currentMinProduct*a[i]));
            minProduct = Math.min(a[i],Math.min(currentMinProduct*a[i],currentMaxProduct*a[i]));
            maxSubArrProduct = Math.max(maxSubArrProduct,maxProduct);
        }
        return maxSubArrProduct;
    }
}

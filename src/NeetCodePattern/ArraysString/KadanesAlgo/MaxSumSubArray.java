package NeetCodePattern.ArraysString.KadanesAlgo;

/**
 * LeetCode - 53
 * Question :
 * Given an array of integers nums, find the subarray with the largest sum and return the sum.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Input: nums = [2,-3,4,-2,2,1,-1,4]
 * Output: 8
 * Explanation: The subarray [4,-2,2,1,-1,4] has the largest sum 8.
 *
 * Input: nums = [-1]
 * Output: -1
 *
 */
public class MaxSumSubArray {
    public static void main(String[] args){
        int[] a = {2,-3,4,-2,2,1,-1,4};
        System.out.println("Max sum got from subarray is: "+getMaxSubArrSum(a));
    }

    private static int getMaxSubArrSum(int[] a) {
        int currentSum=0; //intitially let the current sum be 0
        int maxSum= a[0]; //maximum sum will be the first number
        //traverse the array to find the max subarray
        for(int i:a){
            currentSum=Math.max(currentSum,0); //incase the sum becomes negative then we have to reset
            currentSum+=i; //find current sum by adding the number to existing sum
            maxSum=Math.max(currentSum,maxSum); // find max between the current sum and the maxSum
        }
        return maxSum;
    }
}

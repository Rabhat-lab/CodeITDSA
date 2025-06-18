package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

/**
 * LeetCode 643
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to
 * k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 */
public class MaxAvgSubArray {
    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double avg = getMaxAvg(a, k);
        System.out.println(avg);
    }
    private static double getMaxAvg(int[] a,int k){
        int currentSum = 0;
        //finding the elements of first k elements
        for(int i=0;i<k;i++){
            currentSum+=a[i];
        }

        //intialize the maxSum of first k elements
        int maxSum = currentSum;

        //get the sum of rest elements
        for(int i=k;i<a.length;i++){
            //update current sum by sliding window
            currentSum=currentSum-a[i-k]+a[i];

            //update the maxSUm
            maxSum = Math.max(maxSum,currentSum);
        }
        return (double)maxSum/k;
    }
}

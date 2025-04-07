package ProblemSolvePatterns.SlidingWindow.Fixed;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10-5 will be accepted.
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class MaxAvgSubArray {
    public static void main(String[] args){
        int[] a = {1,12,-5,-6,50,3};
        int k = 4;
        double avg = getMaxAvg(a,k);
        System.out.println(avg);
    }
    private static double getMaxAvg(int[] a, int k){
        double sum = 0;
        for(int i=0;i<k;i++){
            sum+=a[i];
        }
        double maxSum = sum;
        for(int i=k;i<a.length;i++){
            sum = sum+a[i]-a[i-k];
            maxSum=Math.max(sum,maxSum);
        }
        double avg = maxSum/k;
        return avg;
    }
}

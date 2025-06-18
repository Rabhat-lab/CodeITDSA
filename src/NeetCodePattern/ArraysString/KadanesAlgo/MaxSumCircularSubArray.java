package NeetCodePattern.ArraysString.KadanesAlgo;

/**
 * Leetcode - 918
 * You are given a circular integer array nums of length n,
 * return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array.
 * Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element
 * of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once.
 * Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist
 * i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * Input: nums = [-2,4,-5,4,-5,9,4]
 * Output: 15
 * Explanation: Subarray [-2,4,9,4] has maximum sum 15.
 *
 * Thought : Brute force idea is going over all the sub arrays but that will be a very big process
 * because it goes over all subarrays in 2 loops and hence this is time complexity of O(n^2)
 * now we can solve this using Kadanes algorithm which is very effective
 *
 * Kadanes algorithms: idea behind this is we can find the max sum in subarray using the kadanes algoritm
 * which turns out to the mid subarray , in that case if we think we will have remaining elements which
 * dont belong to the subarray are having minimum sum . its true vice versa as well
 * As we found the max sum sub array we will also find the minim sum subarray
 */
public class MaxSumCircularSubArray {
    public static void main(String[] args){
        int[] a = {-2,4,-5,4,-5,9,4};
        int maxSumInCircSunArr = getMaxSumInCircularSubArray(a);
        System.out.println(maxSumInCircSunArr);
    }
    private static int getMaxSumInCircularSubArray(int[] a){
        int currentMaxSum = 0;
        int currentMinSum = 0;
        int maxSum = a[0];
        int minSum = a[0];
        int totalSum=0;
        for(int i:a){
            currentMaxSum = Math.max(currentMaxSum+i,i);
            currentMinSum = Math.min(currentMinSum+i,i);
            totalSum+=i;
            maxSum = Math.max(currentMaxSum,maxSum);
            minSum = Math.min(currentMinSum,minSum);
        }
        return maxSum>0?Math.max(maxSum,totalSum-minSum):maxSum;

    }
}

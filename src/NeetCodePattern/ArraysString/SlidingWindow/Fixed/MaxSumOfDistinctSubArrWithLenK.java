package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 2461 - Maximum Sum of Distinct Subarrays With Length K
 * You are given an integer array nums and an integer k. Find the maximum subarray
 * sum of all the subarrays of nums that meet the following conditions:
 * The length of the subarray is k, and
 * All the elements of the subarray are distinct.
 * Return the maximum subarray sum of all the subarrays that meet the conditions.
 * If no subarray meets the conditions, return 0.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [1,5,4,2,9,9,9], k = 3
 * Output: 15
 * Explanation: The subarrays of nums with length 3 are:
 * - [1,5,4] which meets the requirements and has a sum of 10.
 * - [5,4,2] which meets the requirements and has a sum of 11.
 * - [4,2,9] which meets the requirements and has a sum of 15.
 * - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 * - [9,9,9] which does not meet the requirements because the element 9 is repeated.
 * We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
 *
 * Example 2:
 * Input: nums = [4,4,4], k = 3
 * Output: 0
 * Explanation: The subarrays of nums with length 3 are:
 * - [4,4,4] which does not meet the requirements because the element 4 is repeated.
 * We return 0 because no subarrays meet the conditions.
 *
 * Intuition:
 * An improved approach still uses a sliding window but leverages a HashSet to maintain
 * a set of distinct elements in the current window. This avoids the need to check distinctness
 * explicitly for each subarray by allowing additions and removals of elements from the window
 * in constant time.
 *
 * Steps:
 * Maintain a sliding window with two pointers, ( left ) and ( right ).
 * Use a HashSet to maintain the distinct elements within the current window.
 * Iterate over the array and attempt to build a window of size ( K ).
 * If you've successfully built such a window with all distinct elements,
 * compute the sum and update the maximum sum if necessary.
 * Move the window by adjusting ( left ).
 * But this will not handle a very large data set
 *
 * using hashmap:
 *
 *
 */
public class MaxSumOfDistinctSubArrWithLenK {
    public static void main(String[] args){
        int[] a = {1,5,4,2,9,9,9};
        int k = 3;
        long maxSum = getMaximumSum(a,k);
        System.out.println(maxSum);
    }
    private static long getMaximumSum(int[] nums,int k){
        int n = nums.length;   // Store the length of input array nums
        // Create a HashMap to count the occurrences of each number in a subarray of size k
        Map<Integer, Integer> countMap = new HashMap<>(k);
        long sum = 0;  // Initialize sum of elements in the current subarray

        // Traverse the first subarray of size k and initialize the countMap and sum
        for (int i = 0; i < k; ++i) {
            countMap.merge(nums[i], 1, Integer::sum);
            sum += nums[i];
        }

        // Initialize the answer with the sum of the first subarray if all elements are unique
        long maxSum = countMap.size() == k ? sum : 0;

        // Loop over the rest of the array, updating subarrays and checking for maximum sum
        for (int i = k; i < n; ++i) {
            // Add current element to the countMap and update the sum
            countMap.merge(nums[i], 1, Integer::sum);
            sum += nums[i];

            // Remove the element that's k positions behind the current one from countMap and update the sum
            int count = countMap.merge(nums[i - k], -1, Integer::sum);
            if (count == 0) {
                countMap.remove(nums[i - k]);
            }
            sum -= nums[i - k];

            // Update maxSum if the countMap indicates that we have a subarray with k unique elements
            if (countMap.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        // Return the maximum sum found
        return maxSum;
    }
}

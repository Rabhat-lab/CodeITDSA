package NeetCodePattern.ArraysString.SlidingWindow.Variable;

/**
 * You are given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: target = 10, nums = [2,1,5,1,5,3]
 * Output: 3
 * Explanation: The subarray [5,1,5] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 5, nums = [1,2,1]
 * Output: 0
 *
 */
public class MinSizeSubArrSum {
    public static void main(String[] args){
        int[] nums = {1,2,1};
        int target = 5;
        int minLenSubArr = getMinLenSubArrForSum(nums,target);
        System.out.println(minLenSubArr);
    }

    private static int getMinLenSubArrForSum(int[] nums,int target){
        int minLen=Integer.MAX_VALUE;
        int left=0;
        int sum=0;

        //iterating over the right pointer
        for(int right=0;right< nums.length;right++){
            sum+=nums[right];
            while(sum >= target){
                minLen=Math.min(right-left+1,minLen);
                sum-=nums[left];
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}

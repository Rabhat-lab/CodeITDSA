package NeetCodePattern.ArraysString.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 * Hint 1
 * Will Brute force work here? Try to optimize it.
 *
 * Hint 2
 * Can we optimize it by using some extra space?
 *
 * Hint 3
 * What about storing sum frequencies in a hash table? Will it be useful?
 *
 * Hint 4
 * sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
 * Can we use this property to optimize it.
 */
public class SubArraySumEqualsK {
    public static void main(String[] args){
        int[] a = {1,2,1,2,1};
        int k = 3;
        int result = getNoOfSubArrayWithSumK(a,k);
        int result1 = getNoOfSubArrayWithSumKOptimal(a,k);
        System.out.println(result);
        System.out.println(result1);
    }
    //this has the runtime of 1122ms , time complexity = O(n^2), space complexity = O(n)
    private static int getNoOfSubArrayWithSumK(int[] a,int k){
        int[] totalSum = new int[a.length+1];//same as prefixsum
        totalSum[0]=0;
        int count =0;
        for(int i=1;i<=a.length;i++){
            totalSum[i]=totalSum[i-1]+a[i-1];
        }
        //check each subarray using cumilative subarray
        for(int start=0;start<a.length;start++){
            for(int end=start+1;end<=a.length;end++){
                //sum of nums[start..end] is cumulativeSum[end]-cumulativeSum[start]
                if(totalSum[end]-totalSum[start]==k){
                    count++;
                }
            }
        }
        return count;
    }

    private static int getNoOfSubArrayWithSumKOptimal(int[] a,int k){
        int answer=0, prefixSum=0;
        Map<Integer,Integer> prefixCount = new HashMap<>();
        prefixCount.put(0,1); //base case
        for(int n:a){
            prefixSum+=n;
            answer+=prefixCount.getOrDefault(prefixSum-k,0);
            prefixCount.merge(prefixSum,1,Integer::sum);
        }
        return answer;
    }
}

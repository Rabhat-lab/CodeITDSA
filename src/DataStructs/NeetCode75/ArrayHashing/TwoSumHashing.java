package DataStructs.NeetCode75.ArrayHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode -
 * Given an array of integers nums and an integer target,
 * return the indices i and j such that nums[i] + nums[j] == target and i != j.
 * You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
 * Return the answer with the smaller index first.
 *
 * Example 1:
 * Input:
 * nums = [3,4,5,6], target = 7
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 *
 * Example 2:
 * Input: nums = [4,5,6], target = 10
 * Output: [0,2]
 *
 * Example 3:
 * Input: nums = [5,5], target = 10
 * Output: [0,1]
 *
 *
 */
public class TwoSumHashing {
    public static void main(String[] args){
        int[] nums = {-10,-1,-18,-19};
        int target = -19;
        int[] twoSum = getNumsWhichAddToTarget(nums,target);
        for(int n:twoSum){
            System.out.print(n+" ");
        }
    }
    private static int[] getNumsWhichAddToTarget(int[] nums,int target){
        //create a map to hold the values
        Map<Integer,Integer> numMap = new HashMap<>();
        //iterate and find the elements
        for(int i=0;i<nums.length;i++){
            //initialize the current element to 1st element of array
            int currEle = nums[i];
            //get the other element by subtracting target with current elenent
            int possibleOtherEle = target-currEle;
            //now check if the other element is present in the hashmap
            //if it is present then return the index of the current element and the possible element
            if(numMap.containsKey(possibleOtherEle)){
                return new int[]{i,numMap.get(possibleOtherEle)};
            }
            //each iteration put the current element to the map
            numMap.put(currEle,i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}

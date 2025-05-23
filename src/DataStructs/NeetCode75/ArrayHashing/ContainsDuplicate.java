package DataStructs.NeetCode75.ArrayHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode-217-Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums={1,2,3,1};
        System.out.println(isArrayContainsDuplicate(nums));
    }
    private static boolean isArrayContainsDuplicate(int[] nums){
        Set<Integer> dupCheck = new HashSet<>();
        for(int n:nums){
            if(!dupCheck.add(n)){
                //if the element is already present then add fails
                return true;
            }
        }
        return false;
    }

}

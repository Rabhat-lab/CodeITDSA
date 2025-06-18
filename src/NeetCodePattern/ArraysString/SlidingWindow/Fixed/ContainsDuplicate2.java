package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

import java.util.HashSet;

/**
 * Leetcode 219 :
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicate2 {
    public static void main(String[] args){
        int[] a = {1,2,3,1};
        int k = 3;
        boolean isContainsDuplicate = containsDuplicateCheck(a,k);
        System.out.println(isContainsDuplicate);
    }
    private static boolean containsDuplicateCheck(int[] a,int k){
        HashSet<Integer> window = new HashSet<>();
        int l= 0;
        for(int r=0; r<a.length;r++){
            if(r-l > k){
                window.remove(a[l]);
                l++;
            }
            if(window.contains(a[r])){
                return true;
            }
            window.add(a[r]);
        }
        return false;
    }
}

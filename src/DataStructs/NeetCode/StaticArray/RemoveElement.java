package DataStructs.NeetCode.StaticArray;

/**
 * Leetcode - 27 - Remove element equal to value
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are
 * not equal to val.
 * Consider the number of elements in nums which are not equal to val be k,
 * to get accepted, you need to do the following things:
 * * Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val. The remaining elements of nums are not important
 * as well as the size of nums.
 * * Return k.
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Approach
 * initialize k = 0 which represents the number of elements not equal to the value
 * run a for loop starting from 0 to till the length of the array
 * now compare the element at ith index with the value
 * if they are not equal then add those values to the nums[k++] array
 */
public class RemoveElement {
    public static void main(String[] args){
        int[] a = {0,1,2,2,3,0,4,2};
        int val = 2;
        int ele = getEleAfterRemoveVal(a,val);
        System.out.println(ele);
    }
    private static int getEleAfterRemoveVal(int[] a, int val){
        int k=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=val){
                a[k++] = a[i];
            }
        }
        return k;
    }
}

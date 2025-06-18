package NeetCodePattern.ArraysString.TwoPointers;

/**
 * Given an array of integers numbers that is sorted in non-decreasing order.
 * Return the indices (1-indexed) of two numbers, [index1, index2], such that they add
 * up to a given target number target and index1 < index2. Note that index1 and index2
 * cannot be equal, therefore you may not use the same element twice.
 *
 * There will always be exactly one valid solution.
 * Your solution must use
 * O(1)
 * O(1) additional space.
 *
 * Example 1:
 * Input: numbers = [1,2,3,4], target = 3
 * Output: [1,2]
 * Explanation:
 * The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2.
 * We return [1, 2].
 */
public class TwoSumSortedArr {
    public static void main(String[] args){
        int[] num = {1,2,3,4};
        int target = 3;
        int[] twoSum = getTwoSum(num,target);
        for(int i:twoSum){
            System.out.print(i+" ");
        }
    }
    private static int[] getTwoSum(int[] num,int target){
        int i=0,j=num.length-1;
        while(i<=j){
            if(num[i]+num[j]==target){
                return new int[]{i+1,j+1};
            }
            if(num[i]+num[j]<target){
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}

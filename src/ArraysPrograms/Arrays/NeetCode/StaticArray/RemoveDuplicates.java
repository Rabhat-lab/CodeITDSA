package ArraysPrograms.Arrays.NeetCode.StaticArray;

/**
 * LeetCode - 26 : Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k,
 * to get accepted, you need to do the following things:
 * * Change the array nums such that the first k elements of nums contain the
 * unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * * Return k.
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2,
 * with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Approach :
 * *take an integer k which will be the number of unique elements
 * *now interate over the array starting from index 1 (why ? because if you start from index 0 and compare with
 * *next element at the end when the index reaches the last element then comparing with i+1 will result in the
 * ArrayIndexOutOfBound exception as its going beyond the limit size)
 * *inside the for loop compare element in ith position with the elemnent in the i-1th possition
 * *if the elements are not equal then increment the unique element count
 * and put the value in ith index to i-1th index so that the comparsion goes foward int the iteration
 */
public class RemoveDuplicates {
    public static void main(String[] args){
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int ele = getUniqueElements(a);
        System.out.println(ele);
    }
    private static int getUniqueElements(int[] a){
        int k = 0;
        for(int i=1;i<a.length;i++){
            if(a[i]!=a[i-1]){
                k++;
                a[i-1]=a[i];
            }
        }
        return k+1;
    }
}

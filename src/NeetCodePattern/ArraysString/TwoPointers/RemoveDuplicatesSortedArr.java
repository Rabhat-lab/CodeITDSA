package NeetCodePattern.ArraysString.TwoPointers;

/**
 * You are given an integer array nums sorted in non-decreasing order.
 * Your task is to remove duplicates from nums in-place so that each element appears only once.
 * After removing the duplicates, return the number of unique elements, denoted as k,
 * such that the first k elements of nums contain the unique elements.
 *
 * Note:
 * The order of the unique elements should remain the same as in the original array.
 * It is not necessary to consider elements beyond the first k positions of the array.
 * To be accepted, the first k elements of nums must contain all the unique elements.
 * Return k as the final result.
 *
 * Example 1:
 * Input: nums = [1,1,2,3,4]
 * Output: [1,2,3,4]
 * Explanation: You should return k = 4 as we have four unique elements.
 *
 * Example 2:
 * Input: nums = [2,10,10,30,30,30]
 * Output: [2,10,30]
 * Explanation: You should return k = 3 as we have three unique elements.
 *
 */
public class RemoveDuplicatesSortedArr {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4};
        int uniqueLen = getLenOfUniqueElements(a);
        System.out.println(uniqueLen);
    }
    private static int getLenOfUniqueElements(int[] a){
        int i=0 ;
        for(int j=1;j<a.length;j++){
            if(a[i]!=a[j]){
                i++;
                a[i]=a[j];
            }
        }
        return i+1;
    }
}

package NeetCodePattern.ArraysString.SlidingWindow.Fixed;

/**
 * LeetCode - 1343 - Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 * Given an array of integers arr and two integers k and threshold, return the number of sub-arrays
 * of size k and average greater than or equal to threshold.
 *
 * Example 1:
 * Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * Output: 3
 * Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4,
 * 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
 *
 * Example 2:
 * Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * Output: 6
 * Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
 *
 */
public class NumOfSubArrSizeKAvgGrtOrEq {
    public static void main(String[] args){
        int[] a = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 4;
        int count = getNumOfSubArrFSizeKAvgGrtOrEqThrsh(a,k,threshold);
        System.out.println(count);
    }
    private static int getNumOfSubArrFSizeKAvgGrtOrEqThrsh(int[] a,int k,int threshold){
        int count = 0;
        int currentSum = 0;
        for(int i=0;i<k-1;i++){
            currentSum+=a[i];
        }
        for(int left=0;left<=a.length-k;left++){
            currentSum+=a[left+k-1];
            if((currentSum/k) >= threshold){
                count++;
            }
            currentSum-=a[left];
        }
        return count;
    }
}

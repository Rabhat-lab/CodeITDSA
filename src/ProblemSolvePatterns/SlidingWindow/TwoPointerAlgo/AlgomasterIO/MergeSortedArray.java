package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.AlgomasterIO;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 */
public class MergeSortedArray {
    public static void main(String[] args){
        int[] a={2,2,3,0,0,0};
        int m=3;
        int[] b={1,5,6};
        int n=3;
        for(int x:a){
            System.out.print(x);
        }
        System.out.println();
        getMergedArray(a,b,m,n);
        for(int x:a){
            System.out.print(x);
        }
    }
    private static void getMergedArray(int[]a ,int[] b,int m,int n) {
        //m and n are the indexes of the last non-zero elements of both the arrays
        //length of a is not m its m+n
        //so we need to start filling from the last as the last elements of the array a is empty
        int last = a.length-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            if(a[i]<b[j]){
                a[last]=b[j];
                j--;
            }else{
                a[last]=a[i];
                i--;
            }
            last--;
        }

        //if in case the 2nd array has left over elements - in a case where the 1st element of 2nd array is less than 1st element of 1st array
        // then just append those to the first array
        while(j>=0){
            a[last]=b[j];
            j--;
            last--;
        }

    }

}
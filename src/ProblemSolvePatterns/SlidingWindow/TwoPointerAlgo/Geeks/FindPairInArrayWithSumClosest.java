package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array arr[] of n integers and an integer target,
 * the task is to find a pair in arr[] such that it’s sum is closest to target.
 * Return the pair in sorted order and if there are multiple such pairs return
 * the pair with maximum absolute difference.If no such pair exists return an empty array.
 *
 * Input: arr[] = [10, 30, 20, 5], target = 25
 * Output: [5, 20]
 * Explanation: Out of all the pairs, [5, 20] has sum = 25 which is closest to 25.
 * Input: arr[] = [5, 2, 7, 1, 4], target = 10
 * Output: [2, 7]
 * Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3.
 * Hence,[2, 7] has maximum absolute difference and closest to target.
 * Input: arr[] = [10], target = 10
 * Output: []
 * Explanation: As the input array has only 1 element, return an empty array
 */
public class FindPairInArrayWithSumClosest {
    public static void main(String[] args){
        int[] a={5, 2, 7, 1, 4};
        int t=10;
        Arrays.sort(a);
        List<Integer> pair = getClosestSumPair(a,t);
        for(int i:pair){
            System.out.print(" "+i);
        }
    }
    private static List<Integer> getClosestSumPair(int[] a,int t){
        List<Integer> list = new ArrayList<>();
        int i=0;
        int j=a.length-1;
        int res1 =0;
        int res2 =0;
        int minDiff=Integer.MAX_VALUE;
        while(i<j){
            if(Math.abs(a[i]+a[j]-t)<minDiff){
                res1=a[i];
                res2=a[j];
                minDiff=Math.abs(a[i]+a[j]-t);
            }
            if(a[i]+a[j]<t){
                i++;
            } else {
                j--;
            }
        }
        list.add(res1);
        list.add(res2);
        return list;
    }
}

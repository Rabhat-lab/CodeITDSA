package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Find the closest pair from two sorted arrays
 * Given two arrays , check the number from each array whose sum is closest to the target value given
 * ************
 * Given two arrays arr1[0…m-1] and arr2[0..n-1], and a number x,
 * the task is to find the pair arr1[i] + arr2[j] such that absolute value of (arr1[i] + arr2[j] – x)
 * is minimum.
 * Input:  arr1[] = {1, 4, 5, 7};
 *         arr2[] = {10, 20, 30, 40};
 *             x = 32
 *             Output:  1 and 30
 * Input:  arr1[] = {1, 4, 5, 7};
 *         arr2[] = {10, 20, 30, 40};
 *             x = 50
 * Output:  7 and 40
 * Method :
 * take a pointer p1 which points to start of the array1
 * take a pointer p2 which points to end of array2
 * now take two variables which we will use to hold the element from each of the array
 * when the index is less than the length-1 of the 2nd array
 * start the traversal - if the sum of 2 values of array minus the target value is minimum
 * take the 2 values as the ones which is close to the target element
 * else check if the sum of the two values is greater than the target value ,
 * if it is more then move the 2nd index from the end towards left to reduce the sum value
 * else if it is less then move the 1st index towards the right to increase the sum value
 */
public class ClosestPairFrom2SortedArrays {
    public static void main(String[] args){
        int[] a={1,4,5,7};
        int[] b={10,20,30,40};
        int x=32;
        List<Integer> pair = getClosestPair(a,b,x);
        for(int i:pair){
            System.out.print(i+" ");
        }
    }
    private static List<Integer> getClosestPair(int[] a,int[] b,int x) {
        int i = 0;
        int j = b.length - 1;
        int res1 = 0;
        int res2 = 0;
        int mindiff = Integer.MAX_VALUE;
        List<Integer> pair = new ArrayList<>();
        while (i < b.length - 1) {
            if (Math.abs(a[i] + b[j] - x) < mindiff) {
                res1 = a[i];
                res2 = b[j];
                mindiff = Math.abs(a[i] + b[j] - x);
            }

            if (a[i] + b[j] < x) {
                i++;
            } else {
                j--;
            }
        }
        pair.add(res1);
        pair.add(res2);
        return pair;
    }
}

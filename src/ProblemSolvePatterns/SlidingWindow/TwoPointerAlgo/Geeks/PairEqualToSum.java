package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * This can be done using 2 pointer algorithm
 * Given a sorted array arr (sorted in ascending order) and a target
 * , find if there exists any pair of elements (arr[i], arr[j]) such
 * that their sum is equal to the target.
 *
 * Input: arr[] = {10, 20, 35, 50}, target =70
 * Output:  Yes
 * Explanation : There is a pair (20, 50) with given target.
 *
 * Input: arr[] = {10, 20, 30}, target =70
 * Output :  No
 * Explanation : There is no pair with sum 70
 *
 * Input: arr[] = {-8, 1, 4, 6, 10, 45], target = 16
 * Output: Yes
 * Explanation : There is a pair (6, 10) with given target.
 */
public class PairEqualToSum {
    public static void main(String[] args){
        int[] a = {10,25,35,50};
        int sumKey=70;
        List<Integer> pair = getSumPair(a,sumKey);
        if(null !=pair) {
            System.out.println("Yes! there is a pair with given target sum in the array!");
            for (int i : pair) {
                System.out.print(i+" ");
            }
        } else {
            System.out.println("there is no pair with the given target sum!");
        }
    }

    private static List<Integer> getSumPair(int[] a,int key){
        List<Integer> pair = new ArrayList<>();
        int i=0;
        int j=a.length-1;
        while (i<=j){
            if(a[i]==a[j]){
                return null;
            }
            if(a[i]+a[j]==key){
                pair.add(a[i]);
                pair.add(a[j]);
                return pair;
            } else if(a[i]+a[j]<key){
                i++;
            } else if(a[i]+a[j]>key){
                j--;
            }
        }
        return null;
    }
}

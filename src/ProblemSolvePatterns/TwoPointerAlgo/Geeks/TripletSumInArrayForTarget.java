package ProblemSolvePatterns.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array arr[] of size n and an integer sum,
 * the task is to check if there is a triplet in the array which sums up to the given target sum.
 *
 * Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
 * Output: true
 * Explanation: The triplet [1, 4, 8] sums up to 13
 *
 * Input: arr[] = [1, 2, 4, 3, 6, 7], target = 10
 * Output: true
 * Explanation: The triplets [1, 3, 6] and [1, 2, 7] both sum to 10.
 *
 * Input: arr[] = [40, 20, 10, 3, 6, 7], sum = 24
 * Output: false
 * Explanation: No triplet in the array sums to 24.
 *
 */
public class TripletSumInArrayForTarget {
    public static void main(String[] args){
        int[] a = {1, 2, 4, 3, 6, 7};
        int t=10;
        Arrays.sort(a);
        List<Integer> list = getTripletSum(a,t);
        if (!list.isEmpty()) {
            System.out.println("True! the triplet is found !");
            for (int i : list) {
                System.out.print(" " + i);
            }
        } else {
            System.out.println("False! no triplet found ");
        }
    }
    private static List<Integer> getTripletSum(int[] a,int t){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length-2;i++){
            int j=i+1;
            int k=a.length-1;
            while(j<k){
                if(a[i]+a[j]+a[k]==t){
                    list.add(a[i]);
                    list.add(a[j]);
                    list.add(a[k]);
                }
                if(a[i]+a[j]+a[k]>t){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return list;
    }
}

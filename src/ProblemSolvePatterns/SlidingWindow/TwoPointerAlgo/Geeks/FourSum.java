package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Check if a Quadruple with given Sum Exists in an Array
 * Given an array of integers, check if there are four elements in the array with given sum.
 *
 * Input: arr = {10, 20, 30, 40, 1, 2}, target = 91
 * Output: True
 * Explanation: Sum of 20 + 30 + 40 + 1 = 91
 *
 * Input: arr = {1, 2, 3, 4, 5, 9, 7, 8}, target = 16
 * Output: True
 * Explanation: Sum of output is equal to 16, i.e. 1 + 3 + 5 + 7 = 16.
 *
 * Input: arr = {1, 1, 2, 2], target = 4
 * Output: False
 * Explanation: There is no Quadruple with given target
 */
public class FourSum {
    public static void main(String[] args){
        int[] a={10, 20, 30, 40, 1, 2};
        int t = 91;
        Arrays.sort(a);
        List<Integer> list = getFourSum(a,t);
        if(!list.isEmpty()){
            for(int i:list){
                System.out.print(" "+i);
            }
        }else {
            System.out.println("Four elements not found that form sum of target");
        }
    }
    private static List<Integer> getFourSum(int[] a,int t){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length-3;i++){
            for(int j=i+1;j<a.length-2;j++){
                int k=j+1;
                int l=a.length-1;
                while(k<l){
                    int sum = a[i]+a[j]+a[k]+a[l];
                    if(sum==t){
                        list.add(a[i]);
                        list.add(a[j]);
                        list.add(a[k]);
                        list.add(a[l]);
                    }
                    if(sum<t){
                        l--;
                    }else{
                        k++;
                    }
                }
            }
        }
        return list;
    }
}

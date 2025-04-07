package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers,
 * you have to find three numbers such that the sum of two elements equals the third element.
 *
 * Input: arr[] = [1, 2, 3, 4, 5]
 * Output: True
 * Explanation: The pair (1, 2) sums to 3.
 *
 * Input: arr[] = [3, 4, 5]
 * Output: False
 * Explanation: No triplets satisfy the condition.
 *
 * Input: arr[] = [2, 7, 9, 15]
 * Output: True
 * Explanation: The pair (2, 7) sums to 9.
 *
 */
public class TripletSumEqualToThirdElement {
    public static void main(String[] args){
        int[] a={1, 2, 4, 5, 9};
        List<Integer> list = getTripLet(a);
        if(!list.isEmpty()){
            System.out.println(" True");
            for(int x:list){
                System.out.print(" "+x);
            }
        }else {
            System.out.println("False");
        }
    }
    private static List<Integer> getTripLet(int[] a){
        List<Integer> list = new ArrayList<>();
        for(int k=2;k<a.length;k++){
            int i=0;
            int j = k-1;
            while(i<j){
                if(a[i]+a[j]==a[k]){
                    list.add(a[i]);
                    list.add(a[j]);
                }
                if(a[i]+a[j]<a[k]){
                    i++;
                }else{
                    j--;
                }
            }

        }
        return list;
    }
}

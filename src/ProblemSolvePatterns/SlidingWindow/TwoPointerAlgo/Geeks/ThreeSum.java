package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3 Sum : Find All Triplets with Zero Sum
 * Given an array arr[], the task is to find all possible indices {i, j, k} of triplet
 * {arr[i], arr[j], arr[k]} such that their sum is equal to zero and all indices in a
 * triplet should be distinct (i != j, j != k, k != i).
 * We need to return indices of a triplet in sorted order, i.e., i < j < k.
 *
 * Input: arr[] = {0, -1, 2, -3, 1}
 * Output: {{0, 1, 4}, {2, 3, 4}}
 * Explanation:  Two triplets with sum 0 are:
 * arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
 * arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
 *
 * Input: arr[] = {1, -2, 1, 0, 5}
 * Output: {{0, 1, 2}}
 * Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
 *
 * Input: arr[] = {2, 3, 1, 0, 5}
 * Output: {{}}
 * Explanation: There is no triplet with sum 0
 *
 * so, here we are seeing like i+j+k=0 , rearranging a little it will be i+j=-k
 * after re-arranging we can apply this 2 pointer algorithm on the problem for which
 * we need to sort the array first
 */
public class ThreeSum {
    public static void main(String[] args){
        int[] a = {0, -1, 2, -3, 1};
        Arrays.sort(a);
        List<Integer> list = getThreeSumForZero(a);
        if(!list.isEmpty()) {
            for (int i : list) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println("No elements found summing to 0");
        }
    }
    private static List<Integer> getThreeSumForZero(int[] a){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a.length-2;i++) {
            int j=i+1;
            int k = a.length-1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    list.add(a[i]);
                    list.add(a[j]);
                    list.add(a[k]);
                }
                if (a[i] + a[j] + a[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}

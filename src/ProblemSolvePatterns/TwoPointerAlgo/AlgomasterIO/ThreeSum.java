package ProblemSolvePatterns.TwoPointerAlgo.AlgomasterIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {
    public static void main(String[] args){
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("beforeUsedMem= "+beforeUsedMem);
        int[] a={0,0,0};

        List<List<Integer>> list = getThreeSumTriplets(a);
        for(List<Integer> i:list){
            System.out.print(i);
        }
        System.out.println();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("afterUsedMem= "+afterUsedMem);
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        System.out.println("actualMemUsed= "+actualMemUsed);
    }
    /*private static List<List<Integer>> getThreeSumTriplets(int[] a){
     List<List<Integer>> list = new ArrayList<>();
     for(int i=0;i<a.length-2;i++){
         int j=i+1;
         int k=a.length-1;
         while(j<k){
             if(a[i]+a[j]+a[k]==0){
                 list.add(Arrays.asList(a[i],a[j],a[k]));
             }
             if(a[i]+a[j]+a[k]>0){
                 k--;
             }else {
                 j++;
             }
         }
     }
     return list.stream().distinct().collect(Collectors.toList());
    }*/

    //using Ashish's solution
    private static List<List<Integer>> getThreeSumTriplets(int[] a){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<a.length-2;i++) {
            if (i ==0 || a[i] != a[i - 1]) {
                int j = i + 1;
                int k = a.length - 1;
                while (j < k) {
                    if (a[i] + a[j] + a[k] == 0) {
                        list.add(Arrays.asList(a[i], a[j], a[k]));
                        //removing the duplicates
                        while (j < k && a[j] == a[j + 1]) {
                            j++;
                        }
                        while (j < k && a[k] == a[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    }else if(a[i] + a[j] + a[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return list;
    }
}
package ProblemSolvePatterns.SlidingWindow.TwoPointerAlgo.NeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] where nums[i] + nums[j] + nums[k] == 0,
 * and the indices i, j and k are all distinct.
 * The output should not contain any duplicate triplets.
 * You may return the output and the triplets in any order.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * */
class ThreeSum {
    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(a);
        List<List<Integer>> list = getTriplets(a);
        for (List<Integer> i : list) {
            System.out.print(i);
        }
    }

    private static List<List<Integer>> getTriplets(int[] a){
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            //there are chances that the very next element is same as a[i]
            //so skip the duplicates
            if(i==0 || a[i]!=a[i-1]){
                int j=i+1;
                int k=a.length-1;
                while(j<k){
                    if(a[i]+a[j]+a[k]==0){
                        list.add(Arrays.asList(a[i],a[j],a[k]));
                        //skip the duplicates with j and k
                        while(j<k && a[j]==a[j+1]){j++;}
                        while(j<k && a[k]==a[k-1]){k--;}
                        j++;
                        k--;
                    } else if(a[i]+a[j]+a[k]>0){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return list;
    }
}
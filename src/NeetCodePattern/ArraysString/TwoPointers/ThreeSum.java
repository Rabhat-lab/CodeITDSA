package NeetCodePattern.ArraysString.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4] = [-4,-1,-1,0,1,2]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 */
public class ThreeSum {
    public static void main(String[] args){
        int[] num={-1,0,1,2,-1,-4};
        List<List<Integer>> threeSumList = getThreeSum(num);
        System.out.println(threeSumList);
    }
    private static List<List<Integer>> getThreeSum(int[] num){
        Arrays.sort(num);
        List<List<Integer>> list = new ArrayList<>();
        //external big loop
        for(int i=0;i<num.length-2;i++){
            if(i==0 || num[i]!=num[i-1]){
                int j=i+1;
                int k= num.length-1;
                while(j<k){
                    if(num[i]+num[j]+num[k]==0){
                        list.add(Arrays.asList(num[i],num[j],num[k]));
                        //removing duplicates
                        while(j<k && num[j]==num[j+1]){
                            j++;
                        }
                        while(j<k && num[k]==num[k-1]){
                            k--;
                        }
                        j++;
                        k--;
                    } else if(num[i]+num[j]+num[k]>0){
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

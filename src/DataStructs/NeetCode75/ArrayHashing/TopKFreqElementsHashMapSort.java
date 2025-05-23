package DataStructs.NeetCode75.ArrayHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFreqElementsHashMapSort {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        int[] topEle = getTopKFreqElements(nums,k);
        for(int i:topEle){
            System.out.print(i+" ");
        }
    }
    private static int[] getTopKFreqElements(int[] nums,int k){
        //create a hashmap for holding the frequency of the elements
        Map<Integer,Integer> freqMap = new HashMap<>();
        //iterate over the nums array
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        //convert the entries into list and sort it
        List<Map.Entry<Integer,Integer>> sortedEntries = new ArrayList<>(freqMap.entrySet());
        sortedEntries.sort((a,b)->b.getValue().compareTo(a.getValue()));

        //extract top k elements
        int[] topK = new int[2];
        for(int i=0;i<k;i++){
            topK[i]= sortedEntries.get(i).getKey();
        }
        return topK;
    }
}

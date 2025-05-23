package DataStructs.NeetCode75.ArrayHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements within the array.
 * The test cases are generated such that the answer is always unique.
 * You may return the output in any order.
 *
 * Example 1:
 * Input: nums = [1,2,2,3,3,3], k = 2
 * Output: [2,3]
 *
 * Example 2:
 * Input: nums = [7,7], k = 1
 * Output: [7]
 *
 */
public class TopKFreqElementsMinHeap {
    public static void main(String[] args){
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        int[] topEle = getTopKFreqElements(nums,k);
        for(int i:topEle){
            System.out.print(i+" ");
        }
    }
    private static int[] getTopKFreqElements(int[] nums,int k){
        //create a map to hold the frequency of each element
        //use priority queue to keep track of top k elements
        //getOrDefault -> Returns the value to which the specified key is mapped,
        // or defaultValue if this map contains no mapping for the key. jse1.8
        //Iterate through the map and push each entry into the Min-Heap,
        //evicting the smallest when the heap exceeds size k.

        //frequency mapping
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        //min heap to maintain top k elements
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap =
                new PriorityQueue<>((a,b)->a.getValue().compareTo(b.getValue()));
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll(); //removing the element with smallest frequency
            }
        }

        //extracting elements from the heap
        int[] topK = new int[k];
        for(int i=0;i<k;i++){
            topK[i]=minHeap.poll().getKey();
        }
        return topK;
    }
}

package NeetCodePattern.ArraysString.TwoPointers;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
 * such that each unique element appears at most twice. The relative order of the elements should
 * be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead
 * have the result be placed in the first part of the array nums. More formally, if there are k
 * elements after removing the duplicates, then the first k elements of nums should hold the final
 * result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of
 * nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums
 * being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesSortedArr2 {
    public static void main(String[] args){
        int[] a = {0,0,1,1,1,1,2,3,3};
        int k = getFirstKElements(a);
        System.out.println(k);
    }
    private static int getFirstKElements(int[] a){
        //what we need to do here is keep the occurance of each integer at most two times
        // and it should be sorted
        //let us initialize k=0 which will keep track of position in array where we will place the next
        //unique element which we want which should appear atleast twice
        //iterate over each number using the for each loop
        //for each number check 2 conditions
        //1.if the k is less than 2 which means we are in the begining of the array and
        // we dont need to check for duplicates
        //if k is greater than or equal to 2 we need to check if the number is different from the number that
        //appeared 2 positions before
        //if either is true we put the number to the kth possition in the array ensuring it is final
        //part of the array and increment k
        
        //initialize an index to hold the next element which is unique or 2nd occurance of the element
        int index=0;
        //loop over each element of the array
        for(int n:a){
            //check if the number of occurances of the lement is grater than 2 or the element is unique elment
            if(index>2 || n!=a[index-2]){
                //place current element in index position and increment index
                a[index] = n;
                index++;
            }
        }
        //index represents length of array with the given criteria
        return index;

    }
}

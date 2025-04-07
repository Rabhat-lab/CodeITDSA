package ArraysPrograms.Arrays.Geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayReverse {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6};
        System.out.println("Reverse using Naive Approach "+getReverseUsingNaive(a));
        System.out.println("Reverse using 2 pointers Algo "+getReverseUsing2Pointers(a));
        System.out.println("Reverse using inbuilt functions "+getReverseUsinginbuiltFunc(a));
    }
    private static String getReverseUsingNaive(int[] a){
        int reverse[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            reverse[i]=a[a.length-i-1];
        }
        return Arrays.toString(reverse);
    }

    /**
     * The idea is to maintain two pointers: left and right,
     * such that left points at the beginning of the array and right points to the end of the array.
     * While left pointer is less than the right pointer, swap the elements at these two positions.
     * After each swap, increment the left pointer and decrement the right pointer to move towards the center of array.
     * This will swap all the elements in the first half with their corresponding element in the second half.
     * @param a
     * @return
     */
    private static String getReverseUsing2Pointers(int[] a){
        int start=0;
        int end = a.length-1;
        while(start<=end){
            int temp =0;
            temp = a[start];
            a[start]=a[end];
            a[end]=temp;

            start++;
            end--;
        }
        return Arrays.toString(a);
    }

    /**
     * The idea is to use inbuilt reverse methods available
     */
    private static String getReverseUsinginbuiltFunc(int[] a){
        List<Integer> list = new ArrayList<>(List.of(Integer.valueOf(Arrays.toString(a))));
        Collections.reverse(list);
        return String.valueOf(list);
    }
}

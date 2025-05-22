package DataStructs.GFG.Arrays;

import java.util.Scanner;

/**
 * Given an array, arr of n integers, and an integer element x,
 * find whether element x is present in the array.
 * Return the index of the first occurrence of x in the array, or -1 if it doesn’t exist.
 * Input: arr[] = [1, 2, 3, 4], x = 3
 * Output: 2
 * Explanation: There is one test case with array as [1, 2, 3 4] and element to be searched as 3. Since 3 is present at index 2, the output is 2.
 * Input: arr[] = [10, 8, 30, 4, 5], x = 5
 * Output: 4
 * Explanation: For array [1, 2, 3, 4, 5], the element to be searched is 5 and it is at index 4. So, the output is 4.
 * Input: arr[] = [10, 8, 30], x = 6
 * Output: -1
 * Explanation: The element to be searched is 6 and its not present, so we return -1.
 */
public class LinearSearchArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Array size: ");
        int n=0;
        int x=0;
        if(sc.hasNext()) {
            n = sc.nextInt();
        }
        int[] a = new int[n];
        System.out.println("Array elements are: ");
        for(int i=0;i<n;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }
        System.out.println("Enter the search key: ");
        if(sc.hasNext()) {
            x = sc.nextInt();
        }

        for(int i=0;i<=n;i++){
            if (a[i] == x) {
                System.out.println("the element to be searched is " + x + " and it is at "+i+"th index");
                break;
            }else {
                System.out.println("-1");
                break;
            }
        }
    }
}

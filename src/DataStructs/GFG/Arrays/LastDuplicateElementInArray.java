package DataStructs.GFG.Arrays;

import java.util.Scanner;

/**
 * We have a sorted array with duplicate elements and
 * we have to find the index of last duplicate element and print index of it
 * and also print the duplicate element.
 * If no such element found print a message.
 *
 * Input : arr[] = {1, 5, 5, 6, 6, 7}
 * Output :
 * Last index: 4
 * Last duplicate item: 6
 *
 * Input : arr[] = {1, 2, 3, 4, 5}
 * Output : No duplicate found
 *
 * We simply iterate through the array in reverse order and compare the current and previous element.
 * If a match is found then we print the index and duplicate element.
 * As this is sorted array it will be the last duplicate.
 * If no such element is found we will print the message for it.
 *
 * for i = n-1 to 0
 *    if (arr[i] == arr[i-1])
 *         Print current element and its index.
 *         Return
 * If no such element found print a message of no duplicate found.
 *
 */
public class LastDuplicateElementInArray {
    public static void main(String[] args){
        int[] a= new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            if(sc.hasNext()){
                a[i]=sc.nextInt();
            }
        }
        getLastDuplicateElement(a);
        sc.close();
    }

    private static void getLastDuplicateElement(int[] a){
        for(int i=a.length-1;i>0;i--){
            if(a[i]==a[i-1]){
                System.out.println("Last duplicate element is "+a[i]+" at index "+i);
            }
        }
        System.out.println("No such duplicate found!");
    }
}

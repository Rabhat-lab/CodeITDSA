package ArraysPrograms.Arrays.Geeks;

import java.util.Scanner;

/**
 * Linear search improved by transposition meaning each time the element is found it is swaped with the
 * previous element until it reaches the first index
 * eg: a[] = {2, 5, 7, 1, 6, 4, 5, 8, 3, 7}
 * Search key = 4
 * first iteration - element is found at 5th index
 * so transpose 4th index element with 5th index and hence 4 is now present at 4th index
 * 2nd iteration - element is found at 4th index
 * so transpose 3rd index element with 4th index element and hence 4 is now present at 3rd index
 * continue this until the search element is present at 1st index
 */
public class LinearSearchImprovedByTransposition {
    public static void main(String[] args){
        int n=0;
        System.out.println("Array Size :");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            n=sc.nextInt();
        }
        int a[] = new int[n];
        System.out.println("Array elements: ");
        for(int i=0;i<n;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }
        int x=0;
        System.out.println("ENter search key: ");
        if(sc.hasNext()){
            x=sc.nextInt();
        }
        System.out.println("Is element present in the array? "+isSearchKeyPresent(a,x));
    }

    private static boolean isSearchKeyPresent(int[] a, int x) {
        int i;
        int m=0;
        for(i=0;i<a.length;){
            System.out.println(i);
            if (a[i] == x) { //2,3,4,5,6 - 5
                if (i == 0) {
                    return true;
                }
                m=1;
                int temp = 0;
                temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp; // 2,3,5,4,6
                //i=0;
            }
            i++;
            if(m==1){
                i=0;
            }
        }
        return false;
    }
}

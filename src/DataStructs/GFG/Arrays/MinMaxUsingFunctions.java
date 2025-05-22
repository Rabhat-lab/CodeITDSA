package DataStructs.GFG.Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Min and Max using Library functions Arrays.stream().min/max
 */
public class MinMaxUsingFunctions {
    public static void main(String[] args){
        System.out.println("Enter the Array elements: ");
        Scanner sc = new Scanner(System.in);
        int a[] = new int[5];
        for(int i=0;i<a.length;i++){
            if(sc.hasNext()){
                a[i]=sc.nextInt();
            }
        }
        System.out.println("Minimum in the array is : "+getMinimum(a));
        System.out.println("Maximum in the array is : "+getMaximum(a));
    }

    private static int getMinimum(int[] a){
        return Arrays.stream(a).min().getAsInt();
    }
    private static int getMaximum(int[] a){
        return Arrays.stream(a).max().getAsInt();
    }
}

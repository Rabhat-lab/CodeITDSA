package DataStructs.GFG.Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxElementArraySort {
    public static void main(String args[]){
        //Simplest way using Arrays.sort() method
        int a[] = new int[5];
        int max =0;
        int min =0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            if (sc.hasNext()) {
                a[i] = sc.nextInt();
            }
        }
        Arrays.sort(a);
        System.out.println("Sorted array is :");
        for(int i=0;i<5;i++){
            System.out.print(a[i]+" ");
        }
        max = a[4];
        min = a[0];
        System.out.println();
        System.out.println("Min elememt in array is "+min+" max element in array is "+max);
    }
}

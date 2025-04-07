package ArraysPrograms.Arrays.Geeks;

import java.util.Scanner;

public class MinMaxUsingRecursion {
    public static void main(String args[]){
        System.out.println("Array elements: ");
        int a[]= new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<a.length;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }
        System.out.println("Minimum in an array: "+getMinimum(a,0,a.length));
        System.out.println("Maximum in an array: "+getMaximum(a,0,a.length));
    }

    private static int getMinimum(int[] a,int n,int m){
        return (m==1)?a[n]:Math.min(a[n],getMinimum(a,n+1,m-1));
    }

    private static int getMaximum(int[] a,int n,int m){
        return (m==1)?a[n]:Math.max(a[n],getMaximum(a,n+1,m-1));
    }
}

package ArraysPrograms.Arrays.Geeks;

import java.util.Scanner;

public class LinearSearchArrayMethod {
    public static void main(String[] args){
        System.out.println("Array size: ");
        Scanner sc = new Scanner(System.in);
        int s= 0;
        int x=0;
        if(sc.hasNext()){
            s=sc.nextInt();
        }
        int a[] = new int[s];
        System.out.println("Enter the elements of array: ");
        for(int i=0;i<s;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }
        System.out.println("ENter the search element:");
        if(sc.hasNext()){
            x=sc.nextInt();
        }
        System.out.println("The element is in "+getSearchELementIndex(x,a)+" index");
    }
    private static int getSearchELementIndex(int x, int[] a) {
        for(int i=0;i<a.length;i++){
            if(a[i]==x)
                return i;
        }
        return -1;
    }
}

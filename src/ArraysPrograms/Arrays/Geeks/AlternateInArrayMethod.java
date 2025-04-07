package ArraysPrograms.Arrays.Geeks;

import java.util.ArrayList;
import java.util.Scanner;

public class AlternateInArrayMethod {
    public static void main(String[] args){
        System.out.println("Enter the size of the array: ");
        Scanner sc = new Scanner(System.in);
        int s=0;
        if(sc.hasNext()){
            s=sc.nextInt();
        }
        int a[] = new int[s];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<=a.length;i++){
            if(sc.hasNext()){
                a[i] = sc.nextInt();
            }
        }
        ArrayList<Integer> as = getAlternativeelementsArray(a);
        System.out.println("alternative elements of array is :");
        sc.close();
    }

    private static ArrayList<Integer> getAlternativeelementsArray(int[] a) {
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int x=0;x<=a.length;x+=2){
            n.add(a[x]);
        }
        return n;
    }
}

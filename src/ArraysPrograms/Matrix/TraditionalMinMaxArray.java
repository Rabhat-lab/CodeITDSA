package ArraysPrograms.Matrix;

import java.util.Scanner;

/**
 * Traditional min max using Math.min and Math.max functions
 */
public class TraditionalMinMaxArray {
    public static void main(String[] args){
        System.out.println("Array elements are: ");
        Scanner sc = new Scanner(System.in);
        int a[] = new int[5];
        for(int i=0;i<5;i++) {
            if (sc.hasNext()) {
                a[i] = sc.nextInt();
            }
        }
        System.out.println("Minimum in array is : "+getMinimum(a));
        System.out.println("Maximum in array is : "+getMaximum(a));
    }

    private static int getMinimum(int[] a){
        int min = a[0];
        for(int i=0;i<a.length;i++){
            min = Math.min(min,a[i]);
        }
        return min;
    }

    private static int getMaximum(int[] a){
        int max = a[0];
        for(int i=0;i<a.length;i++){
            max = Math.max(max,a[i]);
        }
        return max;
    }
}

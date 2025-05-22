package DataStructs.GFG.Matrix;

import java.util.Arrays;

public class Sort2DRowWise {
    public static void main(String[] args){
        int[][] a = {{77,11,22,3},{11,89,1,12},{32,11,56,7},{11,22,44,33}};
        sortRowWise(a);
        System.out.println("[");
        for(int[] row:a){
            System.out.print("[");
            for(int j=0;j<row.length;j++){
                if(j>0){
                    System.out.print(", ");
                }
                System.out.print(row[j]);
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
    private static void sortRowWise(int[][] a){
        for(int[] row:a){
            Arrays.sort(row);
        }
    }
}

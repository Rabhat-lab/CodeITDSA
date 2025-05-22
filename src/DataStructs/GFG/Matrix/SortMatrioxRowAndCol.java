package DataStructs.GFG.Matrix;

import java.util.Arrays;

/**
 * Given a n x n matrix. The problem is to sort the matrix row-wise and column wise.
 * Input : mat[][] = { {4, 1, 3},
 *                     {9, 6, 8},
 *                     {5, 2, 7} }
 * Output : 1 3 4
 *          2 5 7
 *          6 8 9
 *
 * Input : mat[][] = { {12, 7, 1, 8},
 *                     {20, 9, 11, 2},
 *                     {15, 4, 5, 13},
 *                     {3, 18, 10, 6} }
 * Output : 1 5 8 12
 *          2 6 10 15
 *          3 7 11 18
 *          4 9 13 20
 *
 * Approach :
 * 1. sort each row
 * 2. find the transpose of the array and store it in another matrix
 * 3. sort rowise of the transposed matrix
 * 4. find the transpose of the transposed matrix
 * */
public class SortMatrioxRowAndCol {
    public static void main(String[] args){
        int[][] a= { {4, 1, 3},
                {9, 6, 8},
                {5, 2, 7} };
        int[][] res = getRowColSorted(a);
        for(int[] row: res){
            System.out.println(Arrays.toString(row));
        }
    }
    private static int[][] getRowColSorted(int[][] a){
        doRowSorting(a);
        int[][] b = getTranspose(a);
        doRowSorting(b);
        int[][] res = getTranspose(b);
        return res;
    }
    private static void doRowSorting(int[][] b){
        for(int[] row:b){
            Arrays.sort(row);
        }
    }
    private static int[][] getTranspose(int[][] b){
        int[][] c= new int[b[0].length][b.length];
        int m = b.length;
        int n = b[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                c[j][i]=b[i][j];
            }
        }
        return c;
    }
}

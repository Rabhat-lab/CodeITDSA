package ArraysPrograms.Matrix;

import java.util.Arrays;

/**
 * Method:
 * 1. traverse the matrix
 * 2. find the transpose of the matrix
 * 3. store the transpose in the 2d vector
 * 4. traverse the row of matrix
 * 5. sort the row
 * 6. store the transpose in the original matrix
 * 7. print the matrix
 */
public class Sort2DCoulmnWIse {
    public static void main(String[] args){
        int[][] a = { { 1, 6, 10 },
                { 8, 5, 9 },
                { 9, 4, 15 },
                { 7, 3, 60 } };

        int res[][] = getColSortedArray(a);
        for(int[] row:res){
            System.out.println(Arrays.toString(row));
        }
    }
    private static int[][] getColSortedArray(int[][] a){
        int[][] b = getTranspose(a);
        doRowSort(b);
        int[][] res = getTranspose(b);
        return res;
    }

    private static int[][] getTranspose(int[][] b){
        int[][] trans = new int[b[0].length][b.length];
        int m=b.length;
        int n=b[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                trans[j][i]= b[i][j];
            }
        }
        return trans;
    }

    private static void doRowSort(int[][] b){
        for(int[] row:b){
            Arrays.sort(row);
        }
    }
}

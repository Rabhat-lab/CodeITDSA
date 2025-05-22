package DataStructs.GFG.Matrix;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args){
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] res = getTranspose(a);
        for(int[] row:res){
            System.out.println(Arrays.toString(row));
        }
    }
    private static int[][] getTranspose(int[][] a){
        int[][] res = new int[a[0].length][a.length];
        int m=a.length;
        int n=a[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i]=a[i][j];
            }
        }
        return res;
    }
}

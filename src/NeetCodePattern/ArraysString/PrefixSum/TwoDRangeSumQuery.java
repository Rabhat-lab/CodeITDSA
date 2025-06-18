package NeetCodePattern.ArraysString.PrefixSum;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * Calculate the sum of the elements of matrix inside the rectangle defined by its
 * upper left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Implement the NumMatrix class:
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements
 * of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower
 * right corner (row2, col2).
 * You must design an algorithm where sumRegion works on O(1) time complexity.
 *
 * Example 1:
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]],
 * [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 * Output
 * [null, 8, 11, 12]
 *
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 *
 */
class NumMatrix{
    //2D matrix
    int[][] prefixSumMatrix;

    public NumMatrix(int[][] matrix){
        int rows = matrix.length, cols=matrix[0].length;
        prefixSumMatrix= new int[rows+1][cols+1];
        for(int r=0;r<rows;r++){
            int prefixSum=0;
            for(int c=0;c<cols;c++){
                prefixSum+=matrix[r][c];
                int above = prefixSumMatrix[r][c+1];
                prefixSumMatrix[r+1][c+1]=prefixSum+above;
            }
        }
    }
    public int sumMatrixRange(int row1,int row2,int col1,int col2){
        row1++;row2++;col1++;col2++;
        int bottomRight = prefixSumMatrix[row2][col2];
        int above = prefixSumMatrix[row1-1][col2];
        int left = prefixSumMatrix[row2][col1-1];
        int topLeft = prefixSumMatrix[row1-1][col1-1];
        return bottomRight-above-left+topLeft;

    }

}
public class TwoDRangeSumQuery {
    public static void main(String[] args){
        int[][] matrix = {{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumMatrixRange(2,4,1,3);
        System.out.println(param_1);
    }
}

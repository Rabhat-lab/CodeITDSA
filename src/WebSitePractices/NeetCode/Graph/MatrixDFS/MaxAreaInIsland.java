package WebSitePractices.NeetCode.Graph.MatrixDFS;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid
 * are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * input - {{0,0,1,0,0,0,0,1,0,0,0,0,0},
 *          {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *          {0,1,1,0,1,0,0,0,0,0,0,0,0},
 *          {0,1,0,0,1,1,0,0,1,0,1,0,0},
 *          {0,1,0,0,1,1,0,0,1,1,1,0,0},
 *          {0,0,0,0,0,0,0,0,0,0,1,0,0},
 *          {0,0,0,0,0,0,0,1,1,1,0,0,0},
 *          {0,0,0,0,0,0,0,1,1,0,0,0,0}}
 * output = 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 *
 */
public class MaxAreaInIsland {
    public static void main(String[] args){
        /*int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};*/
        //int[][] grid = {{0,0,0,0,0,0,0,0}};
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}};

        int area = getIslandArea(grid);
        System.out.println(area);
    }

    private static int getIslandArea(int[][] grid) {
        int maxArea = 0;
        if(grid == null || grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea,dfs(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 0;
        }
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        int area = 1;
        grid[i][j]=0;
        for(int[] dir:direction){
            area+=dfs(grid,i+dir[0],j+dir[1]);
        }

        return area;
    }
}

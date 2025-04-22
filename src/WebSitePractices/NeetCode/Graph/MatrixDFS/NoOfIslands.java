package WebSitePractices.NeetCode.Graph.MatrixDFS;

/**
 * Given a 2D grid "grid" where '1' represents land and '0' represents water,
 * count and return the number of islands.
 * An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water.
 * You may assume water is surrounding the grid (i.e., all the edges are water).
 * Example 1:
 *
 * Input: grid = [
 *     ["0","1","1","1","0"],
 *     ["0","1","0","1","0"],
 *     ["1","1","0","0","0"],
 *     ["0","0","0","0","0"]
 *   ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *     ["1","1","0","0","1"],
 *     ["1","1","0","0","1"],
 *     ["0","0","1","0","0"],
 *     ["0","0","0","1","1"]
 *   ]
 * Output: 4
 *
 */
public class NoOfIslands {
    public static void main(String[] args){
        char[][] grid = {{'1','1','0','0','1'},
                {'1','1','0','0','1'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int num = getNumberOfIslands(grid);
        System.out.println("Number of islands is :"+num);
    }

    private static int getNumberOfIslands(char[][] grid) {
        int island =0;
        int m = grid.length; //row length
        int n = grid[0].length; //col length
        if(grid==null || grid.length==0){
            return 0;
        }
        //traverse the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    //check if adjacent also is 1 for which you need to travel adjacent
                    dfs(grid,i,j);
                    island++;
                }
            }
        }

        return island;
    }

    private static void dfs(char[][] grid, int i, int j) {
        //check the boundary if out of bound and visited
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j]='0';
        //explore the adjacent
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}

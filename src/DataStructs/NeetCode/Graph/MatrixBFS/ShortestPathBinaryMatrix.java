package DataStructs.NeetCode.Graph.MatrixBFS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an n x n binary matrix grid,
 * return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 * to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected
 * (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 2
 *
 * Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 * Output: 4
 *
 * Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 * Output: -1
 *
 * Thought :
 * How to arrive at the conclusion of which dsa to use ?
 * 1. check what is required ? here they are asking for shortest path
 * 2. is it a tree ? no , coz its a matrix format hence it is a graph
 * 3. what best can fit this situation ? it can be bfs or dfs
 * 4. amongst bfs and dfs which you think is better ? bfs is better because it examines all the neighbouring cells
 * of current depth before going to the next depth
 *
 * STeps :
 * 1. lets start with the first cell . now this cell we need to check if it is 1 . if it is 1 then its already blocked
 * so return -1 since we cannot start a path
 * 2. so if it is 0 lets mark it as visited so that we prevent the backtracking and move forward towards the neighbours
 * 3. we will use queue to manage the cells that we will visit next and initially let it hold the initial cell value
 * 4. in each step , we will pop from the queue process it and add all its unvisited 0-neighbours to the queue.
 * 5. we will move in all possible direction - top, left,right,down , top-left,top-right,bottom-left,bottom-right
 * 6. each time we pop from the queue we check if it is bottom right cell , if yes then we have reached the destination
 * and can return the length
 * 7. if we exhaust the queue with out any result then we will return a -1
 */
public class ShortestPathBinaryMatrix {
    public static void main(String[] args){
        int[][] grid = {{0,0,0},
                {1,1,0},
                {1,1,0}};
        int path = getShortestPath(grid);
        System.out.println(path);
    }

    private static int getShortestPath(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        //get the length of the grid
        int m = grid.length;
        int n = grid[0].length;
        int len = 0;
        //start with the first cell, mark the first cell as visited by making it 1
        int[][] visit = new int[4][4];
        //use a deque now to keep track
        Deque<int[]> queue = new ArrayDeque<>();
        //lets start from the top left corner
        queue.offer(new int[]{0,0});
        visit[0][0]=1;
        //now lets start traversing
        while(!queue.isEmpty()){
            for(int i=0;i< queue.size();i++){
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];
                if(r==m-1 && c==n-1){
                    return len;
                }
                int[][] direction = {{r,c+1},{r,c-1},{r+1,c},{r-1,c}};
                for(int j=0;j<4;j++){
                    int newR = direction[j][0];
                    int newC = direction[j][1];
                    if(Math.min(newR,newC)<0 || newR==r || newC==c || grid[newR][newC]==1 || visit[newR][newC]==1 ){
                        continue;
                    }
                    queue.offer(direction[j]);
                    visit[newR][newC]=1;
                }
            }
            len++;
        }
        return len;
    }
}

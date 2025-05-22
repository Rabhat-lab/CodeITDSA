package DataStructs.NeetCode.Graph.AdjacencyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode-133 :: Adjacency List -> Clone a graph
 *
 */
class Node{
    int val;
    List<Node> neighbours;
    //create a default constructor
    public Node(){
        val=0;
        neighbours = new ArrayList<>();
    }
    //constructor passing the val
    public Node(int val){
        this.val = val;
        neighbours = new ArrayList<>();
    }
    //constructor passing the val and the neighbours
    public Node(int val, List<Node> neighbours){
        this.val = val;
        this.neighbours = neighbours;
    }
}

public class CloneGraph {
    // A HashMap to keep track of all the nodes which have already been copied.
    Map<Node,Node> visited = new HashMap<>();
    public static void main(String[] args){

    }
    private Node dfsCloneGraph(Node n){

        //do the null check as if the n is null then return null.
        if(n==null){
            return null;
        }
        // If the node has already been visited i.e., already cloned,
        // return the cloned node from the map.
        if (visited.containsKey(n)) {
            return visited.get(n);
        }
        // Create a new node with the value of the input node (clone it).
        Node cloneNode = new Node(n.val);
        // Mark this node as visited by putting into the visited map.
        visited.put(n, cloneNode);
        // Iterate over all the neighbors of the input node.
        for(Node neigh:n.neighbours) {
            // Perform a depth-first search (DFS) for each neighbor,
            // and add the clone of the neighbor to the neighbors list
            // of the clone node.
            cloneNode.neighbours.add(dfsCloneGraph(neigh));
        }
        // Return the cloned graph node.
        return cloneNode;
    }

}

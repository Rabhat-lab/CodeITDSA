LeetCode - 133 :: Clone Graph 
-----------------------------
Question :
------------
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
public int val;
public List<Node> neighbors;
}

Examples :
-----------
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Approach Explanation:
-------------------------
* Deep copy means creating a new instance of the object which does not have any connection with the input object.
* Here we have to create a deep copy of undirected connected graph
* In graph the nodes are interconnected with edges and this is represented as a Node with integer value and List of neighbouring nodes
* Goal is to copy the given graph into new graph such that any changes to the copied graph does not effect the original graph
* The representation of the graph is done using an adjacency list, which is an array of lists where each list represents a node and contains all of its neighbors.
* How to approach this problem ?
* 1.consider the graph which is given . to create a copy of that graph we need to start from the node
* 2.we need to create nodes as we go and these nodes should be connected
3. to find their neighbours lets have a hashmap which tells that the node is visited , if node is not visited then we add it as new neighbour to the hashmap
4. we repeat this until all nodes and its corresponding neighbours are completed.

// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    
    //Using BFS with HashMap
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null)
            return null;
        
        //HashMap will map a node from the original graph to the corresponsing node on the cloned graph
        //The HashMap will help us not revisit a node which we already visited
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        
        //We also need a queue to do the BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        //Make a clone of the root of the original graph and put it in the HashMap
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        hm.put(node, newHead);
        
        while(!queue.isEmpty()){
            
            //Poll the node from the head of the queue
            UndirectedGraphNode cur = queue.poll();
            //Get all of its neighbors
            List<UndirectedGraphNode> curNeighbor = cur.neighbors;
            
            //Now loop over all the neighbors and if its unvisited, add to the queue, hashmap and make a clone
            for(UndirectedGraphNode neigh: curNeighbor){
                if(!hm.containsKey(neigh)){
                    queue.add(neigh);
                    UndirectedGraphNode cloneNode = new UndirectedGraphNode(neigh.label);
                    hm.put(neigh, cloneNode);
                    hm.get(cur).neighbors.add(cloneNode); //Adding this cloned node to the list of neighbors of 'cur' in the cloned graph
                                                        //since we are looping through all the neighbors of 'cur' 
                }
                else{ // neigh was already previously visited
                     UndirectedGraphNode cloneOfAlreadyVisited = hm.get(neigh);
                     hm.get(cur).neighbors.add(cloneOfAlreadyVisited);    
                }
                    
            }
        }
        return newHead;
    }
}
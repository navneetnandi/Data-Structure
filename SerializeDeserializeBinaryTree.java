/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        //BFS traversal using queue
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        
        if(root == null)
            return("null");
        
        q.add(root);
        while(!q.isEmpty()){
            
            TreeNode node = q.poll();
            
            if(node == null){
                sb.append("null,");
            }
            else{
                sb.append(node.val + ",");
            
            
                //In tradiational Level Order Traversal we used to put a condition to check if node.left or node,right is null
                //If null then we dont enqueue it
                //But here its different. We need to mention that its null. So there are no checks
                q.add(node.left);
                q.add(node.right);
            }
        }
        
        return(sb.toString());
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "null")
            return(null);
        
        String val[] = data.split(",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        
        q.add(root);
        for(int i=1; i<val.length; i++){
            
            TreeNode parent = q.poll();
            
            if(!val[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(val[i]));
                parent.left = left;
                q.add(left);
                
            }
            
            if(!val[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(val[i]));
                parent.right = right;
                q.add(right);
                
            }
                
            
        }
        
        return(root);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
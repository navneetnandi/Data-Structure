/*

Populating next right pointers in Each Node of a Binary Tree

Input:
        1
       /  \
      2    3
     / \    \
    4   5    7

Output:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        
        while(root != null){
            
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode curChild = tempChild;
            
            //This loop is to establish 'next' connection at the level below us
            while(root != null){
                
                if(root.left != null){
                    curChild.next = root.left;
                    curChild = curChild.next;
                }
                
                if(root.right != null){
                    curChild.next = root.right;
                    curChild = curChild.next;
                }
                
                root = root.next;                        
            }//End of establishing next pointers in the next level
            
            root = tempChild.next;
        }
        
        
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


 /*
    A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
    B:     b1 → b2 → b3
 */

//There are two solutions: one by finding length and one without. However both take the same amount of time
// This solution is much cleaner

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return(null);
        
        ListNode a=headA, b=headB;
        
        while(a!=b){
            
            if(a==null)             
                a=headB;
            else
                a=a.next;
            
            if(b==null)             
                b=headA;
            else
                b=b.next;
        }
        
        return(a);
        
    }
}
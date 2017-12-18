/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /*
  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res = new ListNode(0);
        ListNode resHead = res;
        int carry = 0;
        int val1 = 0, val2 = 0;
        
        while( l1 != null || l2 != null ){
            
            //Checking to see if we have finished traversing list L1
            if(l1 == null)
                val1 = 0;
            else{
                val1 = l1.val;
                l1 = l1.next;
            }
            
            //Checking to see if we have finished traversing list L2
            if(l2 == null)
                val2 = 0;
            else{
                val2 = l2.val;
                l2 = l2.next;
            }
            
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            res.next = new ListNode(sum % 10);
            res = res.next;
            
        }
        
        
        //Handling an extra 1 at the end 
        if(carry > 0)
            res.next = new ListNode(carry);
        
        return (resHead.next);
    }
}
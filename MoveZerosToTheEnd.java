/*
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*/

public class Solution {
    public void moveZeroes(int[] nums) {
        
        int l, i, count = 0;
        
        l = nums.length;
        
        for(i =0; i<l; i++){
            if(nums[i] == 0)
                count++;
            else
                nums[i - count] = nums[i];
                
        }
        
        for(i=1; i<=count; i++){
            nums[l-1] = 0;
            l--;
        }
        
    }
}
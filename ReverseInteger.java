
/*

Input: -123
Output: -321

Input: 120
Output: 21
*/

public class Solution {
    public int reverse(int x) {
        
        long copy = x, rev = 0 ;
        
        copy = (long)Math.abs(copy);
        
        while(copy != 0){
            
            rev = (rev*10) + (copy%10);
            copy/=10;
            
        }
        
        if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
            return 0;
        
        if(x < 0)
            rev = rev * (-1);
        
        return (int)rev;
        
    }
}
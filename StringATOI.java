class Solution {
    
    /*
    
    Implement atoi() function
    
    Need to handle the following cases:
    1. Empty input
    2. White spaces in front and back
    3. Negative Numbers or Positive Numbers
    4. Overflow (Greater than Integer.MAX_VALUE or less than Integer.MAX_VALUE)
    
    */
    
    public int myAtoi(String str) {
        
        int start = 0; 
        //Case 1
        if(str == "" || str.length() <= 0)
            return(0);
        
        //Case 2
        str = str.trim();
        
        //Case 3
        int sign = 1;
        if(str.charAt(0) == '-'){
            sign = -1;
            start++;
        }
        else if(str.charAt(0) == '+'){
            sign = 1;
            start++;
        }
        
        double res = 0;
        for(int i= start; i<str.length(); i++){
            
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9')
                res = (res*10) + str.charAt(i) - '0';
            else
                break; //This break is important. Why? Think of test case "-+23". The output should be 0
            
        }
        
        if(sign == -1)
            res = -res;
        
        //Case 4
        if (res > Integer.MAX_VALUE)
		    return Integer.MAX_VALUE;
 
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return ((int)res);
    }
}
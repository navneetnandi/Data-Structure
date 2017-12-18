/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<Character>();
        
        char c[] = s.toCharArray();
        
        for(Character ch: c){
            
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            
            else if(ch == ')'){
                if(st.isEmpty() || st.peek() != '(')
                    return(false);
                else
                    st.pop();
            }
            
            else if(ch == '}'){
                if(st.isEmpty() || st.peek() != '{')
                    return(false);
                else
                    st.pop();
            }
            
            else if(ch == ']'){
                if(st.isEmpty() || st.peek() != '[')
                    return(false);
                else
                    st.pop();
            }
        }
        
        if(st.size() == 0)
            return(true);
        else
            return(false);
        
    }
}
/*

First Unique Character in a string:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/


class Solution {
    public int firstUniqChar(String s) {
        
        int i;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        
        if(s.length() ==  0)
            return(-1);
        
        for(i=0; i<s.length(); i++){
            
            char ch = s.charAt(i);
            if(!hm.containsKey(ch))
                hm.put(ch, 1);
            else{
                int val = hm.get(ch);
                hm.put(ch, val+1);
            }
        }
        
        for(i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(hm.get(ch) == 1)
                return(i);
            
        }
        
        return(-1);
        
    }
}
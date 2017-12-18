class Solution {
    public String multiply(String a, String b) {
        
        int l1 = a.length();
        int l2 = b.length();
        int t, u, i, j;
        int carry = 0;
        
        int res[] = new int[l1+l2];
        String r = "";
        
        //Traversing backwards
        for(i = l1-1; i>= 0; i--){
            for(j = l2-1; j>=0; j--){
                
                int mul = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                
                int p1 = i+j;
                int p2 = i+j+1;
                
                int sum = mul+res[p2];
                
                res[p2] = sum%10;
                res[p1] += sum/10; 
                
            }
        }
        
        
        
    StringBuilder sb = new StringBuilder();
    for(int p : res) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
    }
}
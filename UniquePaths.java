/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/

class Solution {
    
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;

        int[][] dp = new int[m][n];

        //left column
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        //top row
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        
        // By uncommenting the last part the 
        // code calculatest he total possible paths 
        // if the diagonal Movements are allowed
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];  //+ dp[i-1][j-1];
            }
        }

        return dp[m-1][n-1];
}

}
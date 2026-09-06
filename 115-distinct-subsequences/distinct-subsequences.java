class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp= new int [s.length()][t.length()];

        for(int[] row:dp){
            java.util.Arrays.fill(row,-1);
        }
     return solve(s,t,0,0,dp);   
    }

    public int solve(String s,String t,int i,int j, int[][]dp){
        int pick;
        int skip;
        int c=0;

        if(j==t.length())
            return 1;

        if(i==s.length())
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        if(s.charAt(i)== t.charAt(j)){
            pick= solve(s,t,i+1,j+1,dp);
            skip= solve(s,t,i+1,j,dp);

            return dp[i][j]=pick+skip;
        }
        
            skip= solve(s,t,i+1,j,dp);

            return dp[i][j]=skip;
        
    }
}
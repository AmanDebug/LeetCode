class Solution {
    int M= (int) (1e9+7);
    Integer [][][] memo;

    public int solve(int n, int k, int i, int isStarted){

        if(k==0)
        return 1;
        
        if(i>n-1)
        return 0;
        
        if(memo[i][k][isStarted] != null)
            return memo[i][k][isStarted];
        
        long ans=0;

        if(isStarted ==0){
            ans= (ans+solve(n,k,i+1,0))%M;

            ans= (ans+ solve(n,k,i+1,1))%M;
        }
        else{
            ans= (ans+ solve(n,k,i+1,1))%M;

            ans=(ans+solve(n,k-1,i,0))%M;
        }

        return memo[i][k][isStarted]= (int) ans;
    }

    public int numberOfSets(int n, int k) {
        memo= new Integer[n][k+1][2];
        return solve(n,k,0,0) ;
    }
}
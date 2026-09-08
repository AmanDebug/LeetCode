class Solution {
    public int countCommas(int n) {
        return solve(n, 0);
    }

    public int solve(int n,int i){
        if(n-i >999){

            return solve(n, i+1);
        }
            

        return i;
    }
}
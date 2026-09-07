class Solution {
    public int distinctSubseqII(String s) {
     
        int MOD= 1_000_000_007;
        int [] e= new int[26];
        int t=0;
        for(char c:s.toCharArray()){
            int ind= c-'a';
            int ot= t;

            int newSubsequence=(ot+1-e[ind]+MOD)%MOD;

            t=((t+newSubsequence)%MOD);
            e[ind]= (e[ind]+newSubsequence)%MOD;
        }
        return t;
    }
}
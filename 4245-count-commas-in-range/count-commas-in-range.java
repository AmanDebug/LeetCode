class Solution {
    public int countCommas(int n) {
        int i=1;
        if(n>999){
            while(n-i >999){
                i++;
            }
            return i;

        }
        else
            return 0;
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int revX= 0;
        int x1= x;
        while(x!=0){
        int dig= x%10;
        revX= (revX*10)+dig;
        x/=10;
        }

        if(revX== x1)
            return true;
        else
            return false;

    }
}
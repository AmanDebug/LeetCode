class Solution {
    public int maxDepth(String s) {
        int c=0;
        int cmax=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                c++;
                if(cmax<c)
                cmax=c;
            }
            
            
            if(s.charAt(i)==')')
            c--;
        }

        return cmax;
    }
}
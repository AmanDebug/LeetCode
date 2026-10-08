class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ss= new StringBuilder();
        int depth=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                if(depth>0)
                ss.append(c);
                depth++;
            }
            else {
                depth--;
                if(depth>0)
                ss.append(c);
            }
        }
        return ss.toString();
    }
}
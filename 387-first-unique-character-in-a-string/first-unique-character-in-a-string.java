class Solution {
    public int firstUniqChar(String s) {
        String ss= s.toLowerCase();
        int min= Integer.MAX_VALUE;

        for(char i= 'a';i<='z'; i++){
            int First= ss.indexOf(i);

            if(First!= -1 && First == s.lastIndexOf(i)){
                min= Math.min(min, First);
            }

        }
        return min== Integer.MAX_VALUE ? -1 :min;
    }
}
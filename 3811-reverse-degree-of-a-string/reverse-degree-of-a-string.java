class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += (int)(i + 1) * (26 - (s.charAt(i) - 'a'));
        }
        return total;
    }
}
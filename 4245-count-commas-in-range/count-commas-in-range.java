class Solution {
    public int countCommas(int n) {
        if (n > 999) {
            // Every number from 1000 to n has at least 1 comma.
            return n - 999;
        }
        return 0;
    }
}
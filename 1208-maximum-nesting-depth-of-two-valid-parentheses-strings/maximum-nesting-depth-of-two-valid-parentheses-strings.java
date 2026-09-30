class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int dep = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                dep++;
                ans[i] = dep % 2;
            } else {
                ans[i] = dep % 2;
                dep--;
            }
        }
        return ans;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length(), best = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != ')') continue;

            if (s.charAt(i - 1) == '(') {
                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            } else {
                int j = i - dp[i - 1] - 1;   // char before the run ending at i-1
                if (j >= 0 && s.charAt(j) == '(') {
                    dp[i] = dp[i - 1] + 2 + (j >= 1 ? dp[j - 1] : 0);
                }
            }
            best = Math.max(best, dp[i]);
        }
        return best;
    }
}
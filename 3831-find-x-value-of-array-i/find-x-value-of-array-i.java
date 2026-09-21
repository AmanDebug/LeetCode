class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int m = num % k;
            long[] newDp = new long[k];
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    newDp[(r * m) % k] += dp[r];
                }
            }
            newDp[m] += 1;
            dp = newDp;
            for (int x = 0; x < k; x++) {
                result[x] += dp[x];
            }
        }

        return result;
    }
}
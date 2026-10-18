
class Solution {
    private static final long MOD = 1_000_000_007L;
    private long[][] C;

    public int numOfWays(int[] nums) {
        int n = nums.length;

        C = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        long total = dfs(list);
        return (int) ((total - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> list) {
        int size = list.size();
        if (size <= 2) return 1;   

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            if (list.get(i) < root) left.add(list.get(i));
            else right.add(list.get(i));
        }

        long ways = C[size - 1][left.size()];
        ways = ways * dfs(left) % MOD;
        ways = ways * dfs(right) % MOD;
        return ways;
    }
}
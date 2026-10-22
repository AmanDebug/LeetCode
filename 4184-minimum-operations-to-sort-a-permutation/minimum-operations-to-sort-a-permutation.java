class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int p = 0;                       
        while (nums[p] != 0) p++;

        boolean inc = true, dec = true;
        for (int i = 0; i < n; i++) {
            int v = nums[(p + i) % n];
            if (v != i) inc = false;
            if (v != (n - i) % n) dec = false;
        }

        int ans = Integer.MAX_VALUE;

        if (inc) {
            ans = (p == 0) ? 0 : Math.min(p, n - p + 2);
        }
        if (dec) {
            int a = (p + 1) % n;         
            int q = n - 1 - p;           
            ans = Math.min(ans, 1 + Math.min(a, q));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
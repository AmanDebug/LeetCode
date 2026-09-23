class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = totalSum - x;
        
        
        if (target < 0) return -1;   // x is larger than total sum
        if (target == 0) return n;   // must remove everything

        int maxLen = -1;
        int windowSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            windowSum += nums[right];

            
            while (windowSum > target && left <= right) {
                windowSum -= nums[left];
                left++;
            }

            if (windowSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : n - maxLen;
    }
}
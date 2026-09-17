class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // minLen[i] stores the minimum length of a valid sub-array ending at or before index i
        int[] minLen = new int[n];
        int left = 0;
        int sum = 0;
        int bestSoFar = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink the sliding window if the sum exceeds the target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            // If we find a valid sub-array
            if (sum == target) {
                int currentLen = right - left + 1;
                
                // If there's a non-overlapping valid sub-array before the current one starts
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minSum = Math.min(minSum, currentLen + minLen[left - 1]);
                }
                
                // Update the best single sub-array length found so far
                bestSoFar = Math.min(bestSoFar, currentLen);
            }
            
            // Record the minimum length found up to the current index
            minLen[right] = bestSoFar;
        }
        
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
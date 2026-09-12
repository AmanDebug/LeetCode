import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    
    // Helper class to store interval data together with the original index
    class Interval {
        int start, end, weight, id;
        
        public Interval(int start, int end, int weight, int id) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.id = id;
        }
    }
    
    // Helper class to store the DP state (total weight and the chosen indices)
    class State {
        long weight;
        List<Integer> indices;
        
        public State(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsInput) {
        int n = intervalsInput.size();
        Interval[] intervals = new Interval[n];
        
        // Extract data using .get() for lists instead of array bracket notation
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(
                intervalsInput.get(i).get(0), 
                intervalsInput.get(i).get(1), 
                intervalsInput.get(i).get(2), 
                i
            );
        }
        
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
        // DP Table: dp[i][k] represents best State from index i using AT MOST k intervals
        State[][] dp = new State[n + 1][5];
        
        // Initialize base cases (0 weight, empty lists)
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State(0L, new ArrayList<>());
            }
        }
        
        // Step 2 & 3: Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            // Find the next non-overlapping interval using Binary Search
            int nextValid = binarySearch(intervals, intervals[i].end);
            
            for (int k = 1; k <= 4; k++) {
                // Option A: Skip the current interval
                State skip = dp[i + 1][k];
                
                // Option B: Take the current interval
                State takeNext = dp[nextValid][k - 1];
                List<Integer> takeIndices = new ArrayList<>(takeNext.indices);
                takeIndices.add(intervals[i].id);
                Collections.sort(takeIndices); // Keep indices sorted for lexicographical comparison
                
                long takeWeight = (long) intervals[i].weight + takeNext.weight;
                State take = new State(takeWeight, takeIndices);
                
                // Step 4 & 5: Compare Skip vs Take
                dp[i][k] = getBetterState(skip, take);
            }
        }
        
        // The answer for max 4 intervals starting from index 0
        State resultState = dp[0][4];
        int[] result = new int[resultState.indices.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultState.indices.get(i);
        }
        
        return result;
    }
    
    // Binary search to find the first interval that starts strictly after 'targetEnd'
    private int binarySearch(Interval[] intervals, int targetEnd) {
        int left = 0;
        int right = intervals.length - 1;
        int result = intervals.length;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid].start > targetEnd) { // Non-overlapping condition
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    
    // Helper function to resolve ties and find the optimal state
    private State getBetterState(State a, State b) {
        // Condition 1: Maximize Weight
        if (a.weight != b.weight) {
            return a.weight > b.weight ? a : b;
        }
        
        // Condition 2: Tie-breaker - Lexicographically smallest original indices
        int minLen = Math.min(a.indices.size(), b.indices.size());
        for (int i = 0; i < minLen; i++) {
            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i) ? a : b;
            }
        }
        
        // If all matching elements are equal, the shorter list is lexicographically smaller
        return a.indices.size() < b.indices.size() ? a : b;
    }
}
import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] != i) 
                continue; // not a valid starting point

            int start = i;
            int end = last[c];
            boolean val = true;

            int j = i;
            while (j <= end) {
                int cj = s.charAt(j) - 'a';
                if (first[cj] < start) {
                    
                    val = false;
                    break;
                }
                if (last[cj] > end) {
                    end = last[cj]; // extend range to cover this letter fully
                }
                j++;
            }

            if (val) {
                intervals.add(new int[]{start, end});
            }
        }

        
        intervals.sort((a, b) -> a[1] - b[1]); // sort by end ascending

        List<String> res = new ArrayList<>();
        int lastEnd = -1;
        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                res.add(s.substring(interval[0], interval[1] + 1));
                lastEnd = interval[1];
            }
        }

        return res;
    }
}
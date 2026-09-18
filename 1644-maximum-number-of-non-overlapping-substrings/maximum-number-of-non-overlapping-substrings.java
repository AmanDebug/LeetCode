class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < n; i++) {
            int c = chars[i] - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int c = chars[i] - 'a';
            if (first[c] != i) continue;

           
            int end = getValidRightEnd(chars, i, first, last);
            
            if (end != -1) {
                intervals.add(new int[]{i, end});
            }
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

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

    private int getValidRightEnd(char[] ch, int start, int[] first, int[] last) {
        int end = last[ch[start] - 'a'];
        
        for (int j = start; j <= end; j++) {
            int cj = ch[j] - 'a';
            
            
            if (first[cj] < start) {
                return -1; 
            }
            if (last[cj] > end) {
                end = last[cj];
            }
        }
        return end;
    }
}
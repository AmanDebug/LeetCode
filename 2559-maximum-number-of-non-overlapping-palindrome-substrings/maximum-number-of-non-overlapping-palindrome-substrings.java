class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int i = 0;
        int n = s.length();
        
        // Loop until we don't have enough characters left to make a length 'k' string
        while (i <= n - k) {
            
            // 1. Can we make a palindrome of exactly length k?
            if (isPalindrome(s, i, i + k - 1)) {
                count++;
                i += k; // GREEDY: Jump entirely past this palindrome!
            }
            // 2. Can we make a palindrome of exactly length k + 1?
            else if (i + k < n && isPalindrome(s, i, i + k)) {
                count++;
                i += k + 1; // GREEDY: Jump entirely past it!
            }
            // 3. No palindrome found starting at 'i'. Move forward by 1 letter.
            else {
                i++;
            }
        }
        
        return count;
    }
    
    // Your fixed helper method!
    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);          // base for the first valid run
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);   // new base: this ')' can't be matched
                } else {
                    best = Math.max(best, i - stack.peek());
                }
            }
        }
        return best;
    }
}
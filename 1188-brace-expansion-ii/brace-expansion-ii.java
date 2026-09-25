import java.util.*;

/**
 * LeetCode 1096. Brace Expansion II
 * ----------------------------------
 * Given an expression like "{a,b}{c,{d,e}}", return the sorted list of
 * unique strings represented by it.
 *
 * Grammar:
 *   expr   := term (',' term)*        -> union of terms
 *   term   := factor+                 -> concatenation (cartesian product) of factors
 *   factor := letters | '{' expr '}'  -> a literal token, or a nested expression
 *
 * Approach: single-pass recursive-descent parser.
 * - parseExpr() handles ',' as set union.
 * - parseTerm() handles implicit concatenation as a cartesian product of factors.
 * - parseFactor() handles literals and recurses into nested '{...}'.
 * Sets are used throughout so duplicates are removed for free; the final
 * result is sorted once at the end.
 *
 * Time:  O(R log R) where R is the total size of the final result after
 *        building every combination (this is required, since the answer
 *        itself can be exponential in the input size, e.g. "{a,b}{c,d}{e,f}...").
 *        Parsing itself is a single O(n) pass over the input string.
 * Space: O(R) for the result sets plus O(n) recursion depth for nested braces.
 */
class Solution {
    private String expr;
    private int pos;
    private int n;

    public List<String> braceExpansionII(String expression) {
        this.expr = expression;
        this.n = expression.length();
        this.pos = 0;

        Set<String> result = parseExpr();
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }

    // term (',' term)*  -> union
    private Set<String> parseExpr() {
        Set<String> result = parseTerm();
        while (pos < n && expr.charAt(pos) == ',') {
            pos++; // skip ','
            result.addAll(parseTerm());
        }
        return result;
    }

    // factor+ -> cartesian product (concatenation)
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");
        while (pos < n && expr.charAt(pos) != ',' && expr.charAt(pos) != '}') {
            Set<String> factor = parseFactor();
            Set<String> combined = new HashSet<>();
            for (String a : result) {
                for (String b : factor) {
                    combined.add(a + b);
                }
            }
            result = combined;
        }
        return result;
    }

    private Set<String> parseFactor() {
        Set<String> result = new HashSet<>();
        if (expr.charAt(pos) == '{') {
            pos++; // skip '{'
            result = parseExpr();
            pos++; // skip '}'
        } else {
            int start = pos;
            while (pos < n && Character.isLetter(expr.charAt(pos))) {
                pos++;
            }
            result.add(expr.substring(start, pos));
        }
        return result;
    }

    // Simple manual test harness
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] tests = {
            "{a,b}{c,{d,e}}",
            "{{a,z},a{b,c},{ab,z}}",
            "a{b,c}{d,e}f{g,h}"
        };
        for (String t : tests) {
            System.out.println(t + " -> " + sol.braceExpansionII(t));
        }
    }
}
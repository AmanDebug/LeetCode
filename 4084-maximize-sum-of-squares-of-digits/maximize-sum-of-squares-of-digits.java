class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) return "";

        int nines = sum / 9;
        int rem = sum % 9;

        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < nines; i++) sb.append('9');
        if (rem > 0) sb.append((char) ('0' + rem));
        while (sb.length() < num) sb.append('0');

        return sb.toString();
    }
}
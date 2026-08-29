import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // .add() returns false if the number is already in the set
            if (!seen.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length== 0)
            return 0;

        int longest= 1;
        int current= 1;
        java.util.Arrays.sort(nums);

        for(int i= 1; i<nums.length; i++){
            if(nums[i]!= nums[i-1]){

                if(nums[i]==nums[i-1]+1){
                    current++;

                }
                else{
                    longest= Math.max(longest,current);
                    current=1;
                }
            }
        }
        return Math.max(longest,current);
    }
}
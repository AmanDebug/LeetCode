class Solution {
    public int majorityElement(int[] nums) {

        int c;
        int n= nums.length;
        double nn= n/2;
        for(int i=0;i<n; i++){
            c=0;
            for(int j=0; j<n;j++){

            if(nums[i]==nums[j])
                c++;
            }
            if(c>(nn)){
                return nums[i];
        }
        }
        return -1;
    }
}
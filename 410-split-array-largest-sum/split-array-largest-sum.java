class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0;
        int e= nums.length-1;
        for(int i=0;i< nums.length; i++){
            s= Math.max(s,nums[i]);
            e+= nums[i];

        }

        while(s<e){

            int m= s+(e-s)/2;
            int sum= 0;
            int p=1;
            for(int i:nums){
                if(sum+i>m){
                    sum= i;
                    p++;
                }
                else
                    sum+= i;
                    
            }

            if(p>k){
                s=m+1;
            }
            else
                e=m;
        }
        return s;
    }
}
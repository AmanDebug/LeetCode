class Solution {

    public int search(int[] nums, int target){
        int pivot = findPivot(nums);
        //if pivot is -1 that means not rotated array. 
        if(pivot== -1){
            //normal binary search
            return binarySearch(nums, target,0,nums.length-1);
        }

        //pivot is found and 2 ascending sorted arrays found
        if(nums[pivot]== target){
            return pivot;
        }
            
        
        if(target>=nums[0]) {
                return binarySearch(nums, target,0,pivot-1);
        }

        if(target<=nums[0]){
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }
        
        return -1;
    }

    public int binarySearch(int [] nums, int t,int s, int e){
        while(s<=e){
            int m= s+(e-s)/2;
            if(nums[m]== t)
                return m;

            else if(nums[m]>t)
                e=m-1;
            else
                s= m+1;
        }
        return -1;
    }


    public int findPivot(int[] nums) {
        int s= 0;
        int e= nums.length-1;
        while(s<=e){
            int mid= s+(e-s)/2;


            if(mid<e && nums[mid]>nums[mid+1]){
                //first case for pivot
                return mid;
            }


            if(mid>s && nums[mid]<nums[mid-1]){
                return mid-1;
                
            }


            if(nums[mid]<= nums[s]){
                e= mid-1;
            }


            else{
                s= mid+1;
            }
        
        }
        return -1;
    }

}
import java.util.*;
class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int n= nums.length;
        int[] ans= new int[2*n];

        for(int i=0; i<n;i++){
            ans[i]= nums[i];

        }
        for(int j=n; j<2*n; j++){
            ans[j]= nums[j-n];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution ob= new Solution();
        Scanner obj= new Scanner(System.in);        
        int n= obj.nextInt();
        int[] nums= new int [n];
        for(int i=0; i<n; i++){
            nums[i]= obj.nextInt();

        }
        int[] ans= ob.getConcatenation(nums);
        System.out.println(Arrays.toString(ans));

    }

}
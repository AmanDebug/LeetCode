class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n= img1.length;
        int maxOver=0;
        for(int r= -(n-1);r<n;r++){
            for(int c= -(n-1); c<n; c++){
                int count= countOverlap(img1,img2,r,c);

                maxOver= Math.max(maxOver,count);
            }
            
        }
        return maxOver;
    }

    public int countOverlap(int[][] a, int [][] b,int rf,int cf){
        int n= a.length;
        int c=0;
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                int bi=i+rf;
                int bj= j+cf;
                if(bi<0 || bi>=n || bj<0 || bj>=n)
                    continue;
                if(a[i][j]==1 && b[bi][bj]==1){
                    c++;
                }
            }
        }
      return c;

    }
}


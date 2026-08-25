import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        if(grid==null ||grid.length==0){
            return -1;
        }
        int row= grid.length;
        int col= grid[0].length;
        Queue<int[]> queue= new LinkedList<>();
        int c=0;
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                    c++;
            }
        }
        if(c==0)
            return 0;

        int m=0;
        int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            boolean rotThisMin= false;
            int levelSize= queue.size();
            for(int i=0; i<levelSize; i++){
                int[] current= queue.poll();

                for(int[] di: dir){

                    int Nrow= current[0]+di[0];
                    int Ncol= current[1]+di[1];
                    if(Nrow>=0 && Ncol>=0 && Nrow<row && Ncol<col && grid[Nrow][Ncol]==1){
                        grid[Nrow][Ncol]= 2;
                        c--;
                        queue.offer(new int[]{Nrow,Ncol});
                        rotThisMin= true;
                    }
                }
            }
            if(rotThisMin)
                m++;
        }
        return c == 0 ? m : -1;
    }
}
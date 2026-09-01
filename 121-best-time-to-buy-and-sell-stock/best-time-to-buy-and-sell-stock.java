class Solution {
    
    public int maxProfit(int[] prices) {
        int p= Integer.MAX_VALUE;
        int ind=0;
        for(int i= 0; i<prices.length; i++){
            p= Math.min(prices[i],p);
            int profit= prices[i]- p;
            ind= Math.max(ind, profit);
    }
    return ind;
}
}
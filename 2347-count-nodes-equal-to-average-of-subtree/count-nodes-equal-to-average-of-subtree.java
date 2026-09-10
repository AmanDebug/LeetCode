/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    // Returns an array of two integers: {sum, count}
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        
        // Post-order traversal
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // Calculate current subtree sum and count
        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;
        
        // Check if the average equals the current node's value
        if (currentSum / currentCount == node.val) {
            ans++;
        }
        
        return new int[]{currentSum, currentCount};
    }
}
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
    int maxvalue;
    public int maxPathSum(TreeNode root) {
        maxvalue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxvalue;
    }

    private int maxPathDown(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxvalue = Math.max(maxvalue, left+right+root.val);
        return Math.max(left,right) + root.val;
    }
}
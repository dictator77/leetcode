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
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTravel(root);
        return list;
    }

    private void inorderTravel(TreeNode root){
        if(root == null){
            return;
        }
        inorderTravel(root.left);
        list.add(root.val);
        inorderTravel(root.right);
    }
}
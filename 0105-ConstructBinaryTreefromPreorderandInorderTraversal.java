/**
 * 1. Problems:
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * 3. Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
/
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
    /**
     * 1. Approach:
     * recursion
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     */
    /
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        int n = preorder.length;
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);

    }
    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right){
            return null;
        }
        int inorder_root = map.get(preorder[preorder_left]);
        int size_of_inorder = inorder_root - inorder_left;
        TreeNode root = new TreeNode(preorder[preorder_left]);
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_of_inorder, inorder_left, inorder_left + size_of_inorder);
        root.right = myBuildTree(preorder, inorder, preorder_left + size_of_inorder + 1, preorder_right, inorder_left + size_of_inorder + 1, inorder_right);
        return root;
    }
}

class Solution {
    /**
     * 1. Approach:
     * Iterative
     *
     * 2.Complexity:
     * Time:O(N)
     * Space:O(N)
     */
    /
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if(inorder[inorderIndex] != node.val){
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
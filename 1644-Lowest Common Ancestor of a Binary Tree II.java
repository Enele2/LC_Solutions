/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = LCAII(root, p, q);
        if (res != p && res != q) {
            return res;
        } else if (res == p) {
            return LCAII(root, q, null) == q ? p : null;
        } else if (res == q) {
            return LCAII(root, p, null) == p ? q : null;
        } 
        return null;
    }
    
    public TreeNode LCAII(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = LCAII(root.left, p, q);
        TreeNode right = LCAII(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
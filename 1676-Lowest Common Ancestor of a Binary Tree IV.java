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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node : nodes) {
            set.add(node);
        }
        return LCAIV(root, set);
    }
    
    public TreeNode LCAIV(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }
        TreeNode left = LCAIV(root.left, set);
        TreeNode right = LCAIV(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
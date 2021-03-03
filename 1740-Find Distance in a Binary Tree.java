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
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        if (lca == null || p == q) {
            return 0;
        } else if (lca.val == p) {
            if (LCA(lca, q, q) == null) return 0;
            return getHeight(lca, q);
        } else if (lca.val == q) {
            if(LCA(lca, p, p) == null) return 0;
            return getHeight(lca, p);
        }
        return getHeight(lca,p) + getHeight(lca, q);
    }

    public TreeNode LCA(TreeNode root, int p, int q) {
        if(root == null) {
            return root;
        }
        if(root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    public int getHeight(TreeNode root, int p) {
        if(root == null) {
            return -1;
        }
        if(root.val == p) {
            return 0;
        }
        int left = getHeight(root.left, p);
        int right = getHeight(root.right, p);
        if (left > -1) {
            return left + 1;
        } else if(right > -1) {
            return right + 1;
        }
        return -1;
    }
}
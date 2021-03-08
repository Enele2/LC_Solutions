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
    public void recoverTree(TreeNode root) {
        TreeNode[] array = new TreeNode[3];
        findTwoTreeNodes(root, array);
        swap(array[1], array[2]);
    }
    
    public void findTwoTreeNodes(TreeNode root, TreeNode[] array) {
        if(root == null) return;
        findTwoTreeNodes(root.left, array);
        if(array[0] != null && root.val < array[0].val) {
            array[2] = root;
            if(array[1] == null) array[1] = array[0];
            else return;
        }
        array[0] = root;
        findTwoTreeNodes(root.right, array);
    }
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
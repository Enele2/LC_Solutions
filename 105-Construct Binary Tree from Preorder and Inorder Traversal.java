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
    //cannot find bug about this sol
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int i = 0;
        for(int val : inorder){
            indexMap.put(val, i++);
        }
        return helper(preorder, inorder, 0, 0, preorder.length-1, indexMap);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int level, int l, int r, Map<Integer, Integer> map){
            if(l > r) return null;
            int rootVal = preorder[level++];
            TreeNode root = new TreeNode(rootVal);
        
            root.left = helper(preorder, inorder, level, l, map.get(rootVal) - 1, map);
            root.right = helper(preorder, inorder, level, map.get(rootVal) + 1, r, map);
        
            return root;    
    }
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> idxMap = idxMap(inorder);
        return helper(preorder, idxMap, 0, inorder.length - 1, 0, preorder.length - 1);
     }
    
    private TreeNode helper(int[] preorder, Map<Integer, Integer> idxMap, int inLeft, int inRight, int preLeft, int preRight) {
    if (inLeft > inRight) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[preLeft]);
    int size = idxMap.get(preorder[preLeft]);
    root.left = helper(preorder, idxMap, inLeft, size - 1, preLeft + 1, preLeft + size - inLeft);
    root.right = helper(preorder, idxMap, size + 1, inRight, preRight - inRight + size + 1, preRight);
    return root;
  }
  
  private Map<Integer, Integer> idxMap(int[] inOrder) {
    Map<Integer, Integer> idxMap = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      idxMap.put(inOrder[i], i);
    }
    return idxMap;
  }
}
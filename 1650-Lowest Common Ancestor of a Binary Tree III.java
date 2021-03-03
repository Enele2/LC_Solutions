/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int h1 = getHeight(p);
        int h2 = getHeight(q);
        if (h1 > h2) {
            while (h1 > h2) {
                p = p.parent;
                h1--;
            }
        } else if (h2 > h1) {
            while(h2 > h1) {
               q = q.parent;
               h2--;
            }
        } 
        while(p != null && q != null && p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }
    
    public int getHeight(Node p) {
        int height = 0;
        while(p != null) {
            height++;
            p = p.parent;
        }
        return height;
    }
}
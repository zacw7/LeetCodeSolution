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
    // if x has right subtree: find the smallest node in the right subtree
    // else: find its ancestor
    // O(n) - worst case: traverse the whole tree
    // O(1)
    public Node inorderSuccessor(Node x) {
        if (x == null) {
            return null;
        }

        if (x.right != null) {
            Node suc = x.right;
            while (suc.left != null) {
                suc = suc.left;
            }
            return suc;
        }
        Node suc = x.parent;
        while (suc != null && suc.val < x.val) {
            suc = suc.parent;
        }
        if (suc == null || suc.val < x.val) {
            return null;
        } else {
            return suc;
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private List<Integer> nodes = new ArrayList();
    private int index;

    public BSTIterator(TreeNode root) {
        index = 0;
        if (root != null) traverseHelper(root);
    }

    private void traverseHelper(TreeNode node) {
        if (node.left != null) traverseHelper(node.left);
        nodes.add(node.val);
        if (node.right != null) traverseHelper(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        return nodes.get(index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < nodes.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
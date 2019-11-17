/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {

    private TreeNode root;
    private Set<Integer> seen;

    public FindElements(TreeNode root) {
        this.root = root;
        this.seen = new HashSet();
        recover(root, 0);
    }

    private void recover(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        seen.add(val);
        node.val = val;
        recover(node.left, 2 * val  + 1);
        recover(node.right, 2 * val  + 2);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
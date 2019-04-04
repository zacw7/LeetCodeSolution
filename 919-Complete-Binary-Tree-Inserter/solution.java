/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {

    private Queue<TreeNode> queue;
    private TreeNode root, parent;

    public CBTInserter(TreeNode root) {
        if (root == null) return;
        queue = new LinkedList();
        this.root = root;
        this.parent = root;

        Queue<TreeNode> tmp = new LinkedList();
        if (root.left != null) {
            tmp.add(root.left);
            queue.add(root.left);
            root.left = null;
        }
        if (root.right != null) {
            tmp.add(root.right);
            queue.add(root.right);
            root.right = null;
        }

        while (!tmp.isEmpty()) {
            TreeNode node = tmp.poll();
            if (node.left != null) {
                tmp.add(node.left);
                queue.add(node.left);
                node.left = null;
            }
            if (node.right != null) {
                tmp.add(node.right);
                queue.add(node.right);
                node.right = null;
            }
            if (parent.right != null) parent = queue.poll();
            if (parent.left == null) parent.left = node;
            else if (parent.right == null) parent.right = node;
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        if (parent.right != null) parent = queue.poll();
        if (parent.left == null) parent.left = node;
        else if (parent.right == null) parent.right = node;
        queue.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */
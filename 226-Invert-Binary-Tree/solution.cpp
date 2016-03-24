/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if(root) invertChilds(root);
        return root;
    }
    
    void invertChilds(TreeNode* node) {
        if(!node->left && !node->right) return;
        if(node->left) invertChilds(node->left);
        if(node->right) invertChilds(node->right);
        TreeNode* temp = node->left;
        node->left = node->right;
        node->right = temp;
    }
};
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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> retPaths;
        string path = "";
        helper(retPaths, root, path);
        return retPaths;
    }
    
private:
    void helper(vector<string> &retPaths, TreeNode* node, string path) {
        if(!node) return;
        path += to_string(node->val);
        if(node->left==NULL && node->right==NULL) {
            retPaths.push_back(path);
            return;
        } else {
            path += "->";
            helper(retPaths, node->left, path);
            helper(retPaths, node->right, path);
        }
    }
};
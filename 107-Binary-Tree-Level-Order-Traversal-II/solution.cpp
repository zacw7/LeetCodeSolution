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
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> result;
        if(root==NULL) return result;
        vector<TreeNode*> nodes;
        nodes.push_back(root);
        traverseHelper(nodes, result);
        return result;
    }
    
    void traverseHelper(vector<TreeNode*> nodes, vector<vector<int>> &result) {
        if(nodes.empty()) return;
        vector<int> valuesOfLevel;
        vector<TreeNode*> nodesOfNextLevel;
        
        for(vector<TreeNode*>::iterator iter = nodes.begin(); iter != nodes.end(); iter++) {
            valuesOfLevel.push_back((*iter)->val);
            if((*iter)->left) nodesOfNextLevel.push_back((*iter)->left);
            if((*iter)->right) nodesOfNextLevel.push_back((*iter)->right);
        }
        traverseHelper(nodesOfNextLevel, result);
        result.push_back(valuesOfLevel);
    }
};
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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        stack<TreeNode*> pNodes, qNodes;
        if(p) pNodes.push(p);
        if(q) qNodes.push(q);
        while(!pNodes.empty() && !qNodes.empty()) {
            TreeNode *pNode = pNodes.top();
            TreeNode *qNode = qNodes.top();
            pNodes.pop();
            qNodes.pop();
            if(pNode->val != qNode->val) return false;
            if(pNode->left&&qNode->left){
                pNodes.push(pNode->left);
                qNodes.push(qNode->left);
            } else if (pNode->left || qNode->left) {
                return false;
            }
            if(qNode->right&&pNode->right){
                pNodes.push(pNode->right);
                qNodes.push(qNode->right);
            } else if (pNode->right || qNode->right) {
                return false;
            }
        }
        if(!qNodes.empty() || !pNodes.empty()) return false;
        return true;
    }
};
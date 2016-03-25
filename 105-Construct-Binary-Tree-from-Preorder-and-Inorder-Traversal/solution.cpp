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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty() || inorder.empty()) return NULL;
        return buildSubTree(preorder, inorder, preorder.size(), 0, 0);
    }
    
    TreeNode* buildSubTree(vector<int>& preorder, vector<int>& inorder, int length, int preStart, int inStart) {
        if(length==0) return NULL;
        if(length==1) return new TreeNode(preorder[preStart]);
        TreeNode *node = new TreeNode(preorder[preStart]);
        int i = inStart;
        while(inorder.at(i)!=preorder[preStart]){
            i++;
        }
        node->left = buildSubTree(preorder, inorder, i-inStart, preStart+1, inStart);
        node->right = buildSubTree(preorder, inorder, length+inStart-i-1, preStart-inStart+i+1, i+1);
        return node;
    }
};
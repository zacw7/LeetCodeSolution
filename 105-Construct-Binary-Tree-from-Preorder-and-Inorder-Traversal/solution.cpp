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
        int length = preorder.size();
/*        vector<int> leftPre, leftIn, rightPre, rightIn;
        TreeNode *node = new TreeNode(rootValue);
        int i = 0;
        while(inorder.at(i) != rootValue) {
            leftIn.push_back(inorder.at(i++));
            leftPre.push_back(preorder.at(i));
        }
        i++;
        while(i<length) {
            rightPre.push_back(preorder.at(i));
            rightIn.push_back(inorder.at(i));
            i++;
        }
        node->left = buildTree(leftPre, leftIn);
        node->right = buildTree(rightPre, rightIn);*/
        return buildSubTree(preorder, inorder, length, 0, 0);
    }
    
    TreeNode* buildSubTree(vector<int>& preorder, vector<int>& inorder, int length, int preStart, int inStart) {
        if(length==0) return NULL;
        if(length==1) return new TreeNode(preorder[preStart]);
        int rootValue = preorder.at(preStart);
        TreeNode *node = new TreeNode(rootValue);
        int i = inStart;
        while(inorder.at(i)!=rootValue){
            i++;
        }
        node->left = buildSubTree(preorder, inorder, i-inStart, preStart+1, inStart);
        node->right = buildSubTree(preorder, inorder, length+inStart-i-1, preStart-inStart+i+1, i+1);
        return node;
    }
};
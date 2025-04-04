/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    pair<TreeNode*, int> findLCA(TreeNode* root) {
        if (!root) return make_pair(nullptr, 0);
        auto left = findLCA(root->left);
        auto right = findLCA(root->right);
        if (left.second == right.second) {
            return make_pair(root, 1 + left.second);
        } else if (left.second > right.second) {
            return make_pair(left.first, 1 + left.second);
        } else {
            return make_pair(right.first, 1 + right.second);
        }
    }

public:
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        auto result = findLCA(root);
        return result.first;
    }
    
};
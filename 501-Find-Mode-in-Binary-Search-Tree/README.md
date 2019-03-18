# 501. Find Mode in Binary Search Tree

**Easy**

[Original Page](https://leetcode.com/problems/find-mode-in-binary-search-tree/)

Given a binary search tree (BST) with duplicates, find all the [mode(s)](https://en.wikipedia.org/wiki/Mode_(statistics\)) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys __less than or equal to__ the node's key.
- The right subtree of a node contains only nodes with keys __greater than or equal to__ the node's key.
- Both the left and right subtrees must also be binary search trees.

For example:
Given BST `[1,null,2,2]`,
```
   1
    \
     2
    /
   2
```

return `[2]`.

__Note__: If a tree has more than one mode, you can return them in any order.

__Follow up__: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

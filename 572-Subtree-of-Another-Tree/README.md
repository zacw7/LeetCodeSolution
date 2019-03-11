# 572. Subtree of Another Tree

**Easy**

[Original Page](https://leetcode.com/problems/subtree-of-another-tree/)

Given two non-empty binary trees __s__ and __t__, check whether tree __t__ has exactly the same structure and node values with a subtree of __s__. A subtree of __s__ is a tree consists of a node in __s__ and all of this node's descendants. The tree __s__ could also be considered as a subtree of itself.

##### Example 1:
Given tree s:
```
     3
    / \
   4   5
  / \
 1   2
```
Given tree t:
```
   4 
  / \
 1   2
```
Return __true__, because t has the same structure and node values with a subtree of s.

##### Example 2:
Given tree s:
```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```
Given tree t:
```
   4
  / \
 1   2
```
Return __false__.

# 161. One Edit Distance

**Medium**

[Original Page](https://leetcode.com/problems/one-edit-distance/)

Given two strings ___s___ and ___t___, determine if they are both one edit distance apart.

##### Note:
There are 3 possiblities to satisify one edit distance apart:
1. Insert a character into ___s___ to get ___t___
2. Delete a character from ___s___ to get ___t___
3. Replace a character of ___s___ to get ___t___

##### Example 1:
```
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
```

##### Example 2: 
```
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
```

##### Example 3:
```
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
```


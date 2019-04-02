# 368. Largest Divisible Subset

**Medium**

[Original Page](https://leetcode.com/problems/largest-divisible-subset/)

Given a set of __distinct__ positive integers, find the largest subset such that every pair (S<sub>i</sub>, S<sub>j</sub>) of elements in this subset satisfies:

S<sub>i</sub> % S<sub>j</sub> = 0 or S<sub>j</sub> % S<sub>i</sub> = 0.

If there are multiple solutions, return any subset is fine.

##### Example 1:
```
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
```

##### Example 2:
```
Input: [1,2,4,8]
Output: [1,2,4,8]
```

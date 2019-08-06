# 493. Reverse Pairs

**Hard**

[Original Page](https://leetcode.com/problems/reverse-pairs/)

Given an array `nums`, we call `(i, j)` an ___important reverse pair___ if `i < j` and `nums[i] > 2*nums[j]`.

You need to return the number of important reverse pairs in the given array.

##### Example 1:
```
Input: [1,3,2,3,1]
Output: 2
```

##### Example 2:
```
Input: [2,4,3,5,1]
Output: 3
```

##### Note:
1. The length of the given array will not exceed `50,000`.
2. All the numbers in the input array are in the range of 32-bit integer.

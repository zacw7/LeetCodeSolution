# 370. Range Addition

**Medium**

[Original Page](https://leetcode.com/problems/range-addition/)

Assume you have an array of length ___n___ initialized with all __0__'s and are given ___k___ update operations.

Each operation is represented as a triplet: __[startIndex, endIndex, inc]__ which increments each element of subarray __A[startIndex ... endIndex]__ (startIndex and endIndex inclusive) with __inc__.

Return the modified array after all ___k___ operations were executed.

##### Example:
```
Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
```

##### Explanation:
```
Initial state:
[0,0,0,0,0]

After applying operation [1,3,2]:
[0,2,2,2,0]

After applying operation [2,4,3]:
[0,2,5,5,3]

After applying operation [0,2,-2]:
[-2,0,3,5,3]
```

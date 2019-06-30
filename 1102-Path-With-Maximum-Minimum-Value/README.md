# 1102. Path With Maximum Minimum Value

**Medium**

[Original Page](https://leetcode.com/problems/path-with-maximum-minimum-value/)

Given a matrix of integers `A` with R rows and C columns, find the __maximum__ score of a path starting at `[0,0]` and ending at `[R-1,C-1]`.

The score of a path is the __minimum__ value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.

A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south).

##### Example 1:
![](https://assets.leetcode.com/uploads/2019/04/23/1313_ex1.JPG)
```
Input: [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: 
The path with the maximum score is highlighted in yellow. 
```

##### Example 2: 
![](https://assets.leetcode.com/uploads/2019/04/23/1313_ex2.JPG)
```
Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2
```

##### Example 3:
![](https://assets.leetcode.com/uploads/2019/04/23/1313_ex3.JPG)
```
Input: [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3
```

##### Note:
1. `1 <= R, C <= 100`
2. `0 <= A[i][j] <= 10^9`

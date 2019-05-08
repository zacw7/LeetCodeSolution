# 305. Number of Islands II

**Hard**

[Original Page](https://leetcode.com/problems/number-of-islands-ii/)

A 2d grid map of `m` rows and `n` columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, __count the number of islands after each addLand operation__. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

##### Example:
```
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
```

##### Explanation:
Initially, the 2d grid `grid` is filled with water. (Assume 0 represents water and 1 represents land).
```
0 0 0
0 0 0
0 0 0
```

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
```
1 1 0
0 0 0   Number of islands = 1
0 0 0
```

##### Note:
1. `tokens.length <= 1000`
2. `0 <= tokens[i] < 10000`
3. `0 <= P < 10000`

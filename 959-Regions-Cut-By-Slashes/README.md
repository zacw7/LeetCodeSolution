# 959. Regions Cut By Slashes

**Medium**

[Original Page](https://leetcode.com/problems/regions-cut-by-slashes/)

In a N x N `grid` composed of 1 x 1 squares, each 1 x 1 square consists of a `/`, `\`, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a `\` is represented as `"\\"`.)

Return the number of regions.

##### Example 1:
![](https://assets.leetcode.com/uploads/2018/12/15/1.png)
```
Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2018/12/15/2.png)
```
Input:
[
  " /",
  "  "
]
Output: 1
Explanation: The 2x2 grid is as follows:
```

##### Example 3:
![](https://assets.leetcode.com/uploads/2018/12/15/3.png)
```
Input:
[
  "\\/",
  "/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:
```

##### Example 4:
![](https://assets.leetcode.com/uploads/2018/12/15/4.png)
```
Input:
[
  "/\\",
  "\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:
```

##### Example 5:
![](https://assets.leetcode.com/uploads/2018/12/15/5.png)
```
Input:
[
  "//",
  "/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:
```

##### Note:
1. `1 <= grid.length == grid[0].length <= 30`
2. `grid[i][j]` is either `'/'`, `'\'`, or `' '`.

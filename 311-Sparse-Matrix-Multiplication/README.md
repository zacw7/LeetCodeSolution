# 311. Sparse Matrix Multiplication

**Medium**

[Original Page](https://leetcode.com/problems/sparse-matrix-multiplication/)

Given two [sparse matrices](https://en.wikipedia.org/wiki/Sparse_matrix) __A__ and __B__, return the result of __AB.__

You may assume that __A__'s column number is equal to __B__'s row number.

##### Example:
```
Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
```

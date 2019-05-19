# 967. Numbers With Same Consecutive Differences

**Medium**

[Original Page](https://leetcode.com/problems/numbers-with-same-consecutive-differences/)

Return all __non-negative__ integers of length `N` such that the absolute difference between every two consecutive digits is `K`.

Note that __every__ number in the answer __must not__ have leading zeros __except__ for the number `0` itself. For example, `01` has one leading zero and is invalid, but `0` is valid.

You may return the answer in any order.

##### Example 1:
```
Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
```

##### Example 2: 
```
Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
```

##### Note:
1. `1 <= N <= 9`
2. `0 <= K <= 9`

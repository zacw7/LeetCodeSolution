# 656. Coin Path

**Hard**

[Original Page](https://leetcode.com/problems/coin-path/)

Given an array `A` (index starts at `1`) consisting of N integers: A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>N</sub> and an integer `B`. The integer `B` denotes that from any place (suppose the index is `i`) in the array `A`, you can jump to any one of the place in the array `A` indexed `i+1`, `i+2`, …, `i+B` if this place can be jumped to. Also, if you step on the index `i`, you have to pay A<sub>i</sub> coins. If A<sub>i</sub> is -1, it means you can’t jump to the place indexed `i` in the array.

Now, you start from the place indexed `1` in the array `A`, and your aim is to reach the place indexed `N` using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to the place indexed N using minimum coins.

If there are multiple paths with the same cost, return the lexicographically smallest such path.

If it's not possible to reach the place indexed N then you need to return an empty array.

##### Example 1:
```
Input: [1,2,4,-1,2], 2
Output: [1,3,5]
```

##### Example 2:
```
Input: [1,2,4,-1,2], 1
Output: []
```

##### Example 3:
```
Input: tokens = [100,200,300,400], P = 200
Output: 2
```

##### Note:
1. Path Pa<sub>1</sub>, Pa<sub>2</sub>, ..., Pa<sub>n</sub> is lexicographically smaller than Pb<sub>1</sub>, Pb<sub>2</sub>, ..., Pb<sub>m</sub>, if and only if at the first `i` where Pa<sub>i</sub> and Pb<sub>i</sub> differ, Pa<sub>i</sub> < Pb<sub>i</sub>; when no such `i` exists, then `n` < `m`.
2. A<sub>1</sub> >= 0. A<sub>2</sub>, ..., A<sub>N</sub> (if exist) will in the range of [-1, 100].
3. Length of A is in the range of [1, 1000].
4. B is in the range of [1, 100].

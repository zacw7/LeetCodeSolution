# 517. Super Washing Machines

**Hard**

[Original Page](https://leetcode.com/problems/super-washing-machines/)

You have __n__ super washing machines on a line. Initially, each washing machine has some dresses or is empty.

For each __move__, you could choose __any m__ (1 ≤ m ≤ n) washing machines, and pass __one dress__ of each washing machine to one of its adjacent washing machines __at the same time__.

Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the __minimum number of moves__ to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.

##### Example 1:
```
Input: [1,0,5]

Output: 3

Explanation: 
1st move:    1     0 <-- 5    =>    1     1     4
2nd move:    1 <-- 1 <-- 4    =>    2     1     3
3rd move:    2     1 <-- 3    =>    2     2     2
```

##### Example 2:
```
Input: [0,3,0]

Output: 2

Explanation: 
1st move:    0 <-- 3     0    =>    1     2     0
2nd move:    1     2 --> 0    =>    1     1     1
```

##### Example 3:
```
Input: [0,2,0]

Output: -1

Explanation: 
It's impossible to make all the three washing machines have the same number of dresses. 
```

##### Note:
1. The range of n is [1, 10000].
2. The range of dresses number in a super washing machine is [0, 1e5].

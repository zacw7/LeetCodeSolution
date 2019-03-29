# 338. Counting Bits

**Medium**

[Original Page](https://leetcode.com/problems/counting-bits/)

Given a non negative integer number __num__. For every numbers __i__ in the range __0 ≤ i ≤ num__ calculate the number of 1's in their binary representation and return them as an array.

##### Example 1:
```
Input: 2
Output: [0,1,1]
```

##### Example 2:
```
Input: 5
Output: [0,1,1,2,1,2]
```

##### Follow up:
- It is very easy to come up with a solution with run time __O(n*sizeof(integer))__. But can you do it in linear time __O(n)__ /possibly in a single pass?
- Space complexity should be __O(n)__.
- Can you do it like a boss? Do it without using any builtin function like __\_\_builtin\_popcount__ in c++ or in any other language.

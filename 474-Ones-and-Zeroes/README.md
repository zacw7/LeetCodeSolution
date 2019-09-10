# 474. Ones and Zeroes

**Medium**

[Original Page](https://leetcode.com/problems/ones-and-zeroes/)

In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.

For now, suppose you are a dominator of __m__ `0`s and __n__ `1`s respectively. On the other hand, there is an array with strings consisting of only `0`s and `1`s.

Now your task is to find the maximum number of strings that you can form with given __m__ `0`s and __n__ `1`s. Each `0` and `1` can be used at most __once__.

##### Note:
1. The given numbers of `0`s and `1`s will both not exceed `100`
2. The size of given string array won't exceed `600`.

##### Example 1:
```
Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
Output: 4

Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
```

##### Example 2:
```
Input: Array = {"10", "0", "1"}, m = 1, n = 1
Output: 2

Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
```

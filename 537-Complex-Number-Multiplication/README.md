# 537. Complex Number Multiplication

**Medium**

[Original Page](https://leetcode.com/problems/complex-number-multiplication/)

Given two strings representing two [complex numbers](https://en.wikipedia.org/wiki/Complex_number).

You need to return a string representing their multiplication. Note i<sup>2</sup> = -1 according to the definition.

##### Example 1:
```
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
```

##### Example 2:
```
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
```

##### Note:
1. The input strings will not have extra blank.
2. The input strings will be given in the form of __a+bi__, where the integer __a__ and __b__ will both belong to the range of [-100, 100]. And __the output should be also in this form__.

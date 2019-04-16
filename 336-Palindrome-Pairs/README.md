# 336. Palindrome Pairs

**Hard**

[Original Page](https://leetcode.com/problems/add-and-search-word-data-structure-design/)

Given a list of __unique__ words, find all pairs of ___distinct___ indices `(i, j)` in the given list, so that the concatenation of the two words, i.e. `words[i] + words[j]` is a palindrome.

##### Example 1:
```
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
```

##### Example 2:
```
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
```

# 30. Substring with Concatenation of All Words

**Hard**

[Original Page](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

You are given a string, __s__, and a list of words, __words__, that are all of the same length. Find all starting indices of substring(s) in __s__ that is a concatenation of each word in __words__ exactly once and without any intervening characters.

##### Example 1:
```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

##### Example 2:
```
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
```

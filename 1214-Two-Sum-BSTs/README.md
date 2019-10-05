# 1214. Two Sum BSTs

**Medium**

[Original Page](https://leetcode.com/problems/two-sum-bsts/)

Given two binary search trees, return `True` if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer `target`.

##### Example 1:
![](https://assets.leetcode.com/uploads/2019/05/31/1368_1_b.png)
```
Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2019/05/31/1368_2_b.png)
```
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false
```

##### Constraints:
- Each tree has at most `5000` nodes.
- `-10^9 <= target, node.val <= 10^9`

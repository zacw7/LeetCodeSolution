# 774. Minimize Max Distance to Gas Station

**Hard**

[Original Page](https://leetcode.com/problems/minimize-max-distance-to-gas-station/)

On a horizontal number line, we have gas stations at positions `stations[0], stations[1], ..., stations[N-1]`, where `N = stations.length`.

Now, we add `K` more gas stations so that __D__, the maximum distance between adjacent gas stations, is minimized.

Return the smallest possible value of __D__.

##### Example:
```
Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
Output: 0.500000
```

##### Note:
1. `stations.length` will be an integer in range `[10, 2000]`.
2. `stations[i]` will be an integer in range `[0, 10^8]`.
3. `K` will be an integer in range `[1, 10^6]`.
4. Answers within `10^-6` of the true value will be accepted as correct.

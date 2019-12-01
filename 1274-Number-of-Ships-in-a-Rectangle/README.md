# 1274. Number of Ships in a Rectangle

**Hard**

[Original Page](https://leetcode.com/problems/number-of-ships-in-a-rectangle//)

_(This problem is an __interactive problem__.)_

On the sea represented by a cartesian plane, each ship is located at an integer point, and each integer point may contain at most 1 ship.

You have a function `Sea.hasShips(topRight, bottomLeft)` which takes two points as arguments and returns `true` if and only if there is at least one ship in the rectangle represented by the two points, including on the boundary.

Given two points, which are the top right and bottom left corners of a rectangle, return the number of ships present in that rectangle.  It is guaranteed that there are __at most 10 ships__ in that rectangle.

Submissions making __more than 400 calls__ to `hasShips` will be judged _Wrong Answer_.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

##### Example:
![](https://assets.leetcode.com/uploads/2019/07/26/1445_example_1.PNG)
```
Input: 
ships = [[1,1],[2,2],[3,3],[5,5]], topRight = [4,4], bottomLeft = [0,0]
Output: 3
Explanation: From [0,0] to [4,4] we can count 3 ships within the range.
```
##### Constraints:
- On the input `ships` is only given to initialize the map internally. You must solve this problem "blindfolded". In other words, you must find the answer using the given `hasShips` API, without knowing the `ships` position.
- `0 <= bottomLeft[0] <= topRight[0] <= 1000`
- `0 <= bottomLeft[1] <= topRight[1] <= 1000`

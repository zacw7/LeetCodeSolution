# 499. The Maze III

**Medium**

[Original Page](https://leetcode.com/problems/the-maze-iii/)

There is a __ball__ in a maze with empty spaces and walls. The ball can go through empty spaces by rolling __up__ (u), __down__ (d), __left__ (l) or __right__ (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a __hole__ in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the __ball position__, the __hole position__ and the __maze__, find out how the ball could drop into the hole by moving the __shortest distance__. The distance is defined by the number of __empty spaces__ traveled by the ball from the start position (excluded) to the hole (included). Output the moving __directions__ by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the __lexicographically smallest__ way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.

##### Example 1:
![](https://assets.leetcode.com/uploads/2018/10/13/maze_2_example_1.png)
```
Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"

Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".
```

##### Example 2:
![](https://assets.leetcode.com/uploads/2018/10/13/maze_2_example_2.png)
```
Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)

Output: "impossible"

Explanation: The ball cannot reach the hole.
```

##### Note:
1. There is only one ball and one hole in the maze.
2. Both the ball and hole exist on an empty space, and they will not be at the same position initially.
3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
4. The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.

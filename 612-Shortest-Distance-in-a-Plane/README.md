# 612. Shortest Distance in a Plane

**Medium**

[Original Page](https://leetcode.com/problems/shortest-distance-in-a-plane/)

SQL Schema >
```
CREATE TABLE If Not Exists point_2d (x INT NOT NULL, y INT NOT NULL)
Truncate table point_2d
insert into point_2d (x, y) values ('-1', '-1')
insert into point_2d (x, y) values ('0', '0')
insert into point_2d (x, y) values ('-1', '-2')
```

Table `point_2d` holds the coordinates (x,y) of some unique points (more than two) in a plane.

Write a query to find the shortest distance between these points rounded to 2 decimals.
```
| x  | y  |
|----|----|
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |
```

The shortest distance is 1.00 from point (-1,-1) to (-1,2). So the output should be:
```
| shortest |
|----------|
| 1.00     |
```

__Note:__ The longest distance among all the points are less than 10000.

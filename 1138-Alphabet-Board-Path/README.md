# 1138. Alphabet Board Path

**Medium**

[Original Page](https://leetcode.com/problems/alphabet-board-path/)

On an alphabet board, we start at position `(0, 0)`, corresponding to character `board[0][0]`.

Here, `board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]`.

We may make the following moves:

- `'U'` moves our position up one row, if the square exists;
- `'D'` moves our position down one row, if the square exists;
- `'L'` moves our position left one column, if the square exists;
- `'R'` moves our position right one column, if the square exists;
- `'!'` adds the character `board[r][c]` at our current position `(r, c)` to the answer.

Return a sequence of moves that makes our answer equal to `target` in the minimum number of moves.  You may return any path that does so.

##### Example 1:
```
Input: target = "leet"
Output: "DDR!UURRR!!DDD!"
```

##### Example 2:
```
Input: target = "code"
Output: "RR!DDRR!UUL!R!"
```

##### Constraints:
- `1 <= target.length <= 100`
- `target` consists only of English lowercase letters.

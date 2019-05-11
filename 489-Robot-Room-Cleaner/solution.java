/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int i = 0;
    public void cleanRoom(Robot robot) {
        cleanHelper(robot, 0, 0, new HashSet());
    }

    private void cleanHelper(Robot robot, int x, int y, Set<String> visited) {
        if (visited.contains(x)) {
            turnRight(robot);
            turnRight(robot);
            robot.move();
            turnRight(robot);
            turnRight(robot);
            return;
        }
        visited.add(x + "," + y);
        robot.clean();
        // move forward
        if (!visited.contains((x + dx[i]) + "," + (y + dy[i])) && robot.move()) {
            cleanHelper(robot, x + dx[i], y + dy[i], visited);
        }

        // move left
        turnLeft(robot);
        if (!visited.contains((x + dx[i]) + "," + (y + dy[i])) && robot.move()) {
            cleanHelper(robot, x + dx[i], y + dy[i], visited);
        }
        turnRight(robot);

        // move right
        turnRight(robot);
        if (!visited.contains((x + dx[i]) + "," + (y + dy[i])) && robot.move()) {
            cleanHelper(robot, x + dx[i], y + dy[i], visited);
        }

        // move back
        turnRight(robot);
        robot.move();
        if (!visited.contains((x + dx[i]) + "," + (y + dy[i]))) {
            cleanHelper(robot, x + dx[i], y + dy[i], visited);
        }
        turnRight(robot);
        turnRight(robot);
    }

    private void turnLeft(Robot robot) {
        robot.turnLeft();
        i = (i + 3) % 4;
    }

    private void turnRight(Robot robot) {
        robot.turnRight();
        i = (i + 1) % 4;
    }
}
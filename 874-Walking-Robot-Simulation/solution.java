class Solution {
    enum Dir {
        N, S, E, W;
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet();
        for (int[] obstacle : obstacles) obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        int posX = 0, posY = 0;
        Dir direction = Dir.N;
        int max = 0;
        for (int comm : commands) {
            switch (comm) {
                case -2:
                    if (direction == Dir.N) direction = Dir.W;
                    else if (direction == Dir.W) direction = Dir.S;
                    else if (direction == Dir.S) direction = Dir.E;
                    else if (direction == Dir.E) direction = Dir.N;
                    break;
                case -1:
                    if (direction == Dir.N) direction = Dir.E;
                    else if (direction == Dir.E) direction = Dir.S;
                    else if (direction == Dir.S) direction = Dir.W;
                    else if (direction == Dir.W) direction = Dir.N;
                    break;
                default:
                    int targetX = posX, targetY = posY;
                    if (direction == Dir.N) {
                        targetY += comm;
                        for (int[] obs : obstacles) {
                            if (obs[0] == targetX && obs[1] > posY && obs[1] <= targetY) {
                                targetY = obs[1] - 1;
                            }
                        }
                    }
                    else if (direction == Dir.S) {
                        targetY -= comm;
                        for (int[] obs : obstacles) {
                            if (obs[0] == targetX && obs[1] < posY && obs[1] >= targetY) {
                                targetY = obs[1] + 1;
                            }
                        }
                    }
                    else if (direction == Dir.E) {
                        targetX += comm;
                        for (int[] obs : obstacles) {
                            if (obs[1] == targetY && obs[0] > posX && obs[0] <= targetX) {
                                targetX = obs[0] - 1;
                            }
                        }
                    }
                    else if (direction == Dir.W) {
                        targetX -= comm;
                        for (int[] obs : obstacles) {
                            if (obs[1] == targetY && obs[0] < posX && obs[0] >= targetX) {
                                targetX = obs[0] + 1;
                            }
                        }
                    }
                    posX = targetX;
                    posY = targetY;
                    int cur = posX * posX + posY * posY;
                    if (cur > max) max = cur;
            }
        }
        return max;
    }
}
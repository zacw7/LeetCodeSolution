class SnakeGame {

    private Deque<int[]> track;
    private int[][] food;
    private int foodIndex;
    private int height, width;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.track = new LinkedList();
        this.food = food;
        this.foodIndex = 0;
        track.offerFirst(new int[]{0, 0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] pos = track.peekFirst();
        int[] last = track.pollLast();
        int x = pos[0], y = pos[1];
        if (direction.equals("U")) x -= 1;
        else if (direction.equals("D")) x += 1;
        else if (direction.equals("L")) y -= 1;
        else if (direction.equals("R")) y += 1;
        if (x < 0 || y < 0 || x >= height || y >= width) return -1;
        if (isCollided(x, y)) {
            track.offerLast(last);
            return -1;
        }
        if (foodIndex < food.length && food[foodIndex][0] == x && food[foodIndex][1] == y){
            foodIndex++;
            track.offerLast(last);
        }
        track.offerFirst(new int[]{x, y});
        return track.size() - 1;
    }

    private boolean isCollided(int x, int y) {
        for (int[] t : track) {
            if(t[0] == x && t[1] == y) return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
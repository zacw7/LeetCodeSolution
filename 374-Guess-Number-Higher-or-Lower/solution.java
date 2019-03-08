/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0, right = n;
        int pick = left + (right - left) / 2;
        int res = guess(pick);
        while (res != 0) {
            if (res < 0) right = pick;
            else if (res > 0) left = pick;
            pick = left + (right - left) / 2;
            res = guess(pick);
        }
        return pick;
    }
}
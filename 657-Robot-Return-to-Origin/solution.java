class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0, horizontal = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U': vertical++; break;
                case 'D': vertical--; break;
                case 'L': horizontal--; break;
                case 'R': horizontal++; break;
            }
        }
        return vertical == 0 && horizontal == 0;
    }
}
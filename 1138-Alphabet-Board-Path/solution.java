class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[]{0, 0};
        for (char c : target.toCharArray()) {
            move(pos, c, sb);
        }
        return sb.toString();
    }

    private void move(int[] pos, char c, StringBuilder sb) {
        int n = c - 'a';
        int[] nPos = new int[]{n / 5, n % 5};
        if (pos[0] == nPos[0] && pos[1] == nPos[1]) {
            sb.append("!");
            return;
        }
        if (pos[0] == 5 && nPos[0] < pos[0]) {
            pos[0]--;
            sb.append('U');
        }
        if (nPos[0] == 5) {
            while (nPos[1] < pos[1]) {
                pos[1]--;
                sb.append('L');
            }
        }

        while (nPos[0] != pos[0]) {
            if (pos[0] < nPos[0]) {
                pos[0]++;
                sb.append('D');
            } else {
                pos[0]--;
                sb.append('U');
            }
        }
        while (nPos[1] != pos[1]) {
            if (pos[1] < nPos[1]) {
                pos[1]++;
                sb.append('R');
            } else {
                pos[1]--;
                sb.append('L');
            }
        }
        sb.append("!");
    }
}
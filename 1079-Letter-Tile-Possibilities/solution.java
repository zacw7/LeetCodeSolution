class Solution {
    Set<String> seen = new HashSet();
    public int numTilePossibilities(String tiles) {
        char[] t = tiles.toCharArray();
        tileHelper(t, new StringBuilder(), new boolean[t.length]);
        return seen.size() - 1;
    }

    private void tileHelper(char[] t, StringBuilder sb, boolean[] used) {
        if (seen.contains(sb.toString())) {
            return;
        } else {
            seen.add(sb.toString());
        }
        for (int i = 0; i < t.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            sb.append(t[i]);
            tileHelper(t, sb, used);
            sb.setLength(sb.length() - 1);
            used[i] = false;
        }
    }
}
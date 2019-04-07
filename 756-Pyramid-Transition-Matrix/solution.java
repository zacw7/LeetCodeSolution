class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int level = bottom.length();
        return dfs(bottom.toCharArray(), level - 1, new char[level - 1], 0, allowed);
    }

    public boolean dfs(char[] base, int level, char[] cur, int index, List<String> allowed) {
        if (level == 0) return true;
        if (index == level) return dfs(cur, level - 1, new char[level - 1], 0, allowed);
        for (String allow : allowed) {
            if (allow.charAt(0) == base[index] && allow.charAt(1) == base[index + 1]) {
                cur[index] = allow.charAt(2);
                if (dfs(base, level, cur, index + 1, allowed)) return true;
            }
        }
        return false;
    }
}
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        if (n == 0 || k == 0) {
            return sb.toString();
        }
        if (n == 1) {
            for (int i = 0; i < k; i++) {
                sb.append((char)(i + '0'));
            }
            return sb.toString();
        }
        Set<String> seen = new HashSet();
        for (int i = 0; i < n - 1; i++) {
            sb.append("0");
        }
        String node = sb.toString();
        sb.setLength(0);
        traverse(sb, node, k, seen);
        sb.append(node);
        return sb.toString();
    }

    private void traverse(StringBuilder sb, String node, int k, Set<String> seen) {
        for (int i = 0; i < k; i++) {
            String cur = node + i;
            if (!seen.contains(cur)) {
                seen.add(cur);
                traverse(sb, cur.substring(1), k, seen);
                sb.append(i);
            }
        }
    }
}
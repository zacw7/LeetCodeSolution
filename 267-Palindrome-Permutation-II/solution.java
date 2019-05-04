class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.length() == 1) {
            res.add(s);
            return res;
        }

        int[] chCount = new int[256];
        for (char c : s.toCharArray()) {
            chCount[c]++;
        }

        char[] chs = new char[s.length() / 2];
        int idx = 0;
        String center = "";
        for (int i = 0; i < 256; i++) {
            if (chCount[i] % 2 == 1) {
                if (center.length() > 0) {
                    return res;
                }
                center = String.valueOf((char) i);
                chCount[i]--;
            }
            chCount[i] /= 2;
            while (chCount[i]-- > 0) {
                chs[idx++] = (char) i;
            }
        }
        boolean[] used = new boolean[chs.length];
        palidromeHelper(chs, new StringBuilder(), used, res, center);
        return res;
    }

    private void palidromeHelper(char[] chs, StringBuilder sb, boolean[] used, List<String> res, String center) {
        if (sb.length() == chs.length) {
            res.add(sb.toString() + center + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (used[i] || (i > 0 && chs[i] == chs[i - 1] && !used[i - 1])) {
                continue;
            }
            sb.append(chs[i]);
            used[i] = true;
            palidromeHelper(chs, sb, used, res, center);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
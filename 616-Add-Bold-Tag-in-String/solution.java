class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] isBold = new boolean[s.length()];
        for (String d : dict) {
            int idx = s.indexOf(d);
            while (idx >= 0) {
                markBold(isBold, idx, idx + d.length());
                idx = s.indexOf(d, idx + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < isBold.length; i++) {
            if (isBold[i] && (i == 0 || isBold[i - 1] == false)) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (isBold[i] && (i == isBold.length - 1 || isBold[i + 1] == false)) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    private void markBold(boolean[] isBold, int start, int end) {
        for (int i = start; i < end; i++) {
            isBold[i] = true;
        }
    }
}
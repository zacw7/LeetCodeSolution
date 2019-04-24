class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length) {
            int n1 = Integer.valueOf(v1[i]);
            int n2 = Integer.valueOf(v2[i]);
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
            i++;
        }
        while (i < v1.length) {
            if (Integer.valueOf(v1[i++]) > 0) {
                return 1;
            }
        }
        while (i < v2.length) {
            if (Integer.valueOf(v2[i++]) > 0) {
                return -1;
            }
        }
        return 0;
    }
}
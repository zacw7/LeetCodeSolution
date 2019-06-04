class Solution {
    Map<String, Boolean> cache = new HashMap();
    public boolean isInterleave(String s1, String s2, String s3) {
        String key = s1 + "/" + s2;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean res = true;
        if (s1.length() == 0) {
            res = s2.equals(s3);
        } else if (s2.length() == 0) {
            res = s1.equals(s3);
        } else {
            res = (s1.charAt(0) == s3.charAt(0) && isInterleave(s1.substring(1), s2, s3.substring(1)))
                    || (s2.charAt(0) == s3.charAt(0) && isInterleave(s1, s2.substring(1), s3.substring(1)));
        }
        cache.put(key, res);
        return res;
    }
}
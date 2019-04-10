class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet(), repeated = new HashSet();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            if (seen.contains(str)) repeated.add(str);
            else seen.add(str);
        }
        return new ArrayList(repeated);
    }
}
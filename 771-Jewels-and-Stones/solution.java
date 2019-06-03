class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewelSet = new HashSet();
        for (char j : J.toCharArray()) {
            jewelSet.add(j);
        }
        int num = 0;
        for (char s : S.toCharArray()) {
            if (jewelSet.contains(s)) {
                num++;
            }
        }
        return num;
    }
}
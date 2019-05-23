class Solution {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> seen = new HashSet();
        Set<Integer> cur = new HashSet();
        for (int num : A) {
            Set<Integer> tmp = new HashSet();
            tmp.add(num);
            for (int prev : cur) {
                tmp.add(prev | num);
            }
            seen.addAll(tmp);
            cur = tmp;
        }
        return seen.size();
    }
}
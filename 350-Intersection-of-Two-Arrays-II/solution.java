class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numsMap = new HashMap();
        List<Integer> inList = new ArrayList();
        for (int i : nums1) {
            numsMap.put(i, numsMap.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            int count = numsMap.getOrDefault(i, 0);
            if (count > 0) {
                inList.add(i);
                numsMap.put(i, count - 1);
            }
        }
        return inList.stream().mapToInt(i->i).toArray();
    }
}
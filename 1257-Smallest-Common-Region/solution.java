class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parents = new HashMap();
        for (List<String> r : regions) {
            String p = r.get(0);
            for (int i = 1; i < r.size(); i++) {
                parents.put(r.get(i), p);
            }
        }
        Set<String> set = new HashSet();
        while (region1 != null && !region1.equals("")) {
            set.add(region1);
            region1 = parents.getOrDefault(region1, "");
        }
        while (region2 != null && !region2.equals("")) {
            if (set.contains(region2)) {
                return region2;
            }
            set.add(region2);
            region2 = parents.getOrDefault(region2, "");
        }
        return "";
    }
}
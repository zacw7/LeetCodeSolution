class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        for (int n : arr2) {
            set.add(n);
            map.put(n, 0);
        }
        List<Integer> missed = new ArrayList();
        for (int n : arr1) {
            if (set.contains(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                missed.add(n);
            }
        }
        Collections.sort(missed);
        int i = 0;
        for (int n : arr2) {
            int count = map.get(n);
            while (count-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int j = 0; j < missed.size(); j++) {
            arr1[i++] = missed.get(j);
        }
        return arr1;
    }
}
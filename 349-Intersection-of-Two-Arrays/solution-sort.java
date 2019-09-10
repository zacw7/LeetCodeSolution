class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> commonList = new ArrayList();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (commonList.isEmpty()
                        || commonList.get(commonList.size() - 1) != nums1[i]) {
                    commonList.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        int[] ans = new int[commonList.size()];
        for (int k = 0; k < commonList.size(); k++) {
            ans[k] = commonList.get(k);
        }
        return ans;
    }
}
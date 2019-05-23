class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0) return nums2;
        Map<Integer, Integer> nextGreaterMap = new HashMap();
        nextGreaterMap.put(nums2[nums2.length - 1], -1);
        for (int i = nums2.length - 1; i > 0; i--) {
            if (nums2[i - 1] < nums2[i]) {
                nextGreaterMap.put(nums2[i - 1], nums2[i]);
            } else {
                int nextGreaterElement = nextGreaterMap.get(nums2[i]);
                while (nextGreaterElement != -1 && nextGreaterElement < nums2[i - 1]) {
                    nextGreaterElement = nextGreaterMap.get(nextGreaterElement);
                }
                nextGreaterMap.put(nums2[i - 1], nextGreaterElement);
            }
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }
        return ans;
    }
}
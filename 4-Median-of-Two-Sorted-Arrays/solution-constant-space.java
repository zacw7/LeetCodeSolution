class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        if (nums1.length == 0 || nums2.length == 0) {
            int[] nums = (nums1.length > 0) ? nums1 : nums2;
            return (nums.length % 2 == 0) ? (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0 : nums[nums.length /2];
        }
        int p1 = 0, p2 = 0;
        int len = nums1.length + nums2.length, halfPoint = len / 2;
        int median = 0, prev = 0;
        while (p1 + p2 <= halfPoint) {
            prev = median;
            if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] < nums2[p2])) median = nums1[p1++];
            else median = nums2[p2++];
        }
        if (len % 2 == 1) return median;
        else return (median + prev) / 2.0;
    }
}
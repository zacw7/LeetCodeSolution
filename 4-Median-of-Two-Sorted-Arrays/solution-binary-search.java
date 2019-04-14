class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len == 0) return 0;
        if (len % 2 == 0) {
            return (double) (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
        } else {
            return (double) findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    private int findKth(int[] nums1, int index1, int[] nums2, int index2, int k) {
        if (index1 >= nums1.length) {
            return nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return nums1[index1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }

        int mid1 = (index1 + k / 2 - 1 < nums1.length)
                ? nums1[index1 + k / 2 - 1]
                : Integer.MAX_VALUE;
        int mid2 = (index2 + k / 2 - 1 < nums2.length)
                ? nums2[index2 + k / 2 - 1]
                : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return findKth(nums1, index1 + k / 2, nums2, index2, k - k / 2);
        } else {
            return findKth(nums1, index1, nums2, index2 + k / 2, k - k / 2);
        }
    }
}
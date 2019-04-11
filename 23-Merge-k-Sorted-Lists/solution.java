class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0;
        Queue<Integer> minHeap = new PriorityQueue();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        int p1 = 0, p2 = 0;
        int len = nums1.length + nums2.length, halfLen = len / 2;
        while (maxHeap.size() < halfLen) {
            if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] < nums2[p2])) maxHeap.add(nums1[p1++]);
            else maxHeap.add(nums2[p2++]);
        }
        while (p1 < nums1.length) minHeap.add(nums1[p1++]);
        while (p2 < nums2.length) minHeap.add(nums2[p2++]);
        if (len % 2 == 1) return minHeap.poll();
        else return (maxHeap.poll() + minHeap.poll()) / 2d;
    }
}
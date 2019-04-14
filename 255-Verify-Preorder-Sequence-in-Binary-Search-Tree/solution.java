class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return verifyHelper(preorder, 0, preorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean verifyHelper(int[] preorder, int start, int end, int upperBound, int lowerBound) {
        if (start > end) {
            return true;
        }

        if (preorder[start] < lowerBound || preorder[start] > upperBound) {
            return false;
        }

        int rSubIdx = start + 1;
        while (rSubIdx <= end && preorder[start] > preorder[rSubIdx]) {
            rSubIdx++;
        }

        return verifyHelper(preorder, start + 1, rSubIdx - 1, preorder[start], lowerBound)
                && verifyHelper(preorder, rSubIdx, end, upperBound, preorder[start]);
    }
}
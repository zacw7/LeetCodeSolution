class Solution {
    // sliding window
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0, satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            total += customers[i];
            if (grumpy[i] == 1) {
                customers[i] = -customers[i];
            } else {
                satisfied += customers[i];
            }
        }
        System.out.println(Arrays.toString(customers));
        if (X >= customers.length) {
            return total;
        }
        if (X == 0) {
            return satisfied;
        }
        int transfer = 0;
        int l = 0, r = X;
        for (int i = 0; i < r; i++) {
            if (customers[i] < 0) {
                transfer -= customers[i];
            }
        }
        int maxTransfer = transfer;
        int maxL = 0, maxR = r - 1;
        while (r < customers.length) {
            if (customers[l] < 0) {
                transfer += customers[l];
            }
            if (customers[r] < 0) {
                transfer -= customers[r];
            }
            if (transfer > maxTransfer) {
                maxTransfer = transfer;
                maxL = l + 1;
                maxR = r;
            }
            l++;
            r++;
        }
        satisfied = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0 || (i >= maxL && i <= maxR)) {
                satisfied += Math.abs(customers[i]);
            }
        }
        return satisfied;
    }
}
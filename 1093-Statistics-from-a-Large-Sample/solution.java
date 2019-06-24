class Solution {
    public double[] sampleStats(int[] count) {
        double min = 256.0, max = 0.0, mean = 0.0, median = 0.0, mod = 0.0;
        int sum = 0, total = 0, maxC = count[0];
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i * 1.0);
                max = i * 1.0;
                if (count[i] > maxC) {
                    maxC = count[i];
                    mod = i * 1.0;
                }
                sum += i * count[i];
                total += count[i];
            }
        }
        if (total == 0) {
            return new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
        }
        for (int i = 0; i < 256; i++) {
            mean += (double) i * count[i] / total;
        }
        int i = 0, curCount = 0;
        while (i < 256 && curCount < total / 2) {
            if (count[i] > 0) {
                curCount += count[i];
            }
            i++;
        }
        System.out.println(total);
        System.out.println(total / 2);
        System.out.println(curCount);
        median = (double)(i - 1);
        if (total % 2 == 0 && curCount == total / 2) {
            while (i < 256 && count[i] == 0) {
                i++;
            }
            median = (median + i) / 2.0;
        }

        return new double[]{min, max, mean, median, mod};
    }
}
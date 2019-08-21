class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        List<Integer> distList = new ArrayList();
        for (int i = 1; i < stations.length; i++) {
            distList.add(stations[i] - stations[i - 1]);
        }
        Collections.sort(distList, Collections.reverseOrder());
        double lo = 0, hi = distList.get(0);
        while (hi - lo > 1e-6) {
            double mid = lo + (hi - lo) / 2;
            if (possible(mid, distList, K)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private boolean possible(double D, List<Integer> distList, int K) {
        for (int i = 0; i < distList.size() && K >= 0; i++) {
            int need = (int) (distList.get(i) / D);
            if (need == 0) {
                break;
            } else {
                K -= need;
            }
        }
        return K >= 0;
    }
}
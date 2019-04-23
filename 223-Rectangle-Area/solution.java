class Solution {
    // compute intersection
    // T: O(1)
    // S: O(1)
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersecX = (A < E) ? computeIntersection(A, C, E, G) : computeIntersection(E, G, A, C);
        int intersecY = (B < F) ? computeIntersection(B, D, F, H) : computeIntersection(F, H, B, D);
        return (C - A) * (D - B) + (G - E) * (H - F)  - intersecX * intersecY;
    }

    private int computeIntersection(int S1, int E1, int S2, int E2) {
        if (E1 <= S2) {
            return 0;
        } else {
            if (E2 <= E1) {
                return E2 - S2;
            } else {
                return E1 - S2;
            }
        }
    }
}
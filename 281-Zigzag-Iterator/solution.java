public class ZigzagIterator {

    private List<List<Integer>> matrix;
    private int r, c;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.matrix = new ArrayList();
        matrix.add(v1);
        matrix.add(v2);
        this.r = this.c = 0;
    }

    public int next() {
        if (hasNext()) {
            return matrix.get(r++).get(c);
        } else {
            return 0;
        }
    }

    public boolean hasNext() {
        while (r < matrix.size() && c >= matrix.get(r).size()) {
            r++;
        }
        if (r == matrix.size()) {
            r = 0;
            c++;
        }
        while (r < matrix.size() && c >= matrix.get(r).size()) {
            r++;
        }
        return r < matrix.size() && c < matrix.get(r).size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
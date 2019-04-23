class Vector2D {

    private int[][] v;
    private int r, c;

    public Vector2D(int[][] v) {
        this.v = v;
        this.r = 0;
        this.c = 0;
    }

    public int next() {
        while (r < v.length && c >= v[r].length) {
            c = 0;
            r++;
        }
        return v[r][c++];
    }

    public boolean hasNext() {
        while (r < v.length && c >= v[r].length) {
            c = 0;
            r++;
        }
        return r < v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
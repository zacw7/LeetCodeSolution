class SnapshotArray {

    private TreeMap<Integer, Integer>[] deltas;
    private int[] arr;
    private int id;

    public SnapshotArray(int length) {
        this.id = 0;
        this.arr = new int[length];
        this.deltas = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            deltas[i] = new TreeMap();
        }
    }

    public void set(int index, int val) {
        deltas[index].put(id, val);
    }

    public int snap() {
        id++;
        return id - 1;
    }

    public int get(int index, int snap_id) {
        Integer floorKey = deltas[index].floorKey(snap_id);
        return floorKey == null ? 0 : deltas[index].get(floorKey);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
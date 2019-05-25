class LogSystem {

    TreeMap<String, List<Integer>> storage;

    public LogSystem() {
        this.storage = new TreeMap();
    }

    public void put(int id, String timestamp) {
        List<Integer> list = storage.getOrDefault(timestamp, new ArrayList());
        list.add(id);
        storage.put(timestamp, list);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        s = processTimestamp(s, gra, 0);
        e = processTimestamp(e, gra, 1);
        List<Integer> res = new ArrayList();
        for (List<Integer> list : storage.subMap(s, true, e, true).values()) {
            res.addAll(list);
        }
        return res;
    }

    private String processTimestamp(String ts, String gra, int type) {
        String mask = (type == 1) ? "9999:12:31:23:59:59": "0000:00:00:00:00:00";
        if (gra.equals("Year")) {
            return ts.substring(0, 4) + mask.substring(4);
        } else if (gra.equals("Month")) {
            return ts.substring(0, 7) + mask.substring(7);
        } else if (gra.equals("Day")) {
            return ts.substring(0, 10) + mask.substring(10);
        } else if (gra.equals("Hour")) {
            return ts.substring(0, 13) + mask.substring(13);
        } else if (gra.equals("Minute")) {
            return ts.substring(0, 16) + mask.substring(16);
        } else if (gra.equals("Second")) {
            return ts;
        }
        return ts;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
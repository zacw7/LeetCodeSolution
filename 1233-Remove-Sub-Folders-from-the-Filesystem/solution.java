class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Dir dirTree = new Dir("");
        for (String f : folder) {
            String[] subs = f.substring(1).split("/");
            Dir node = dirTree;
            for (String s : subs) {
                if (!node.subs.containsKey(s)) {
                    node.subs.put(s, new Dir(s));
                }
                node = node.subs.get(s);
            }
            node.isEnd = true;
        }
        List<String> res = new ArrayList();
        dfs(dirTree, "", res);
        return res;
    }

    private void dfs(Dir node, String cur, List<String> res) {
        if (node.isEnd) {
            res.add(cur);
            return;
        }
        for (Map.Entry<String, Dir> entry : node.subs.entrySet()) {
            dfs(entry.getValue(), cur + "/" + entry.getKey(), res);
        }
    }

    class Dir {
        boolean isEnd;
        String cur;
        Map<String, Dir> subs;

        Dir(String cur) {
            this.isEnd = false;
            this.cur = cur;
            this.subs = new HashMap();
        }
    }
}
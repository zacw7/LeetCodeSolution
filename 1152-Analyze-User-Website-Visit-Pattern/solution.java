class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int N = username.length;
        Integer[] orders = new Integer[N];
        for (int i = 0; i < N; i++) {
            orders[i] = i;
        }
        Arrays.sort(orders, (a, b) -> timestamp[a] - timestamp[b]);
        Map<String, List<String>> userVisits = new HashMap();
        for (int i = 0; i < N; i++) {
            int idx = orders[i];
            List<String> visits = userVisits.getOrDefault(username[idx], new ArrayList());
            visits.add(website[idx]);
            userVisits.put(username[idx], visits);
        }
        int maxCount = 0;
        Map<String, Integer> seqCountMap = new HashMap();
        for (List<String> visits : userVisits.values()) {
            Set<String> seqs = new HashSet();
            findAllSeqs(visits, 0, new ArrayList(), seqs);
            for (String seq : seqs) {
                int c = seqCountMap.getOrDefault(seq, 0) + 1;
                seqCountMap.put(seq, c);
                maxCount = Math.max(maxCount, c);
            }
        }
        PriorityQueue<List<String>> pq = new PriorityQueue<List<String>>((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0).compareTo(b.get(0));
            } else if (!a.get(1).equals(b.get(1))) {
                return a.get(1).compareTo(b.get(1));
            } else {
                return a.get(2).compareTo(b.get(2));
            }
        });
        for (Map.Entry<String, Integer> entry : seqCountMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                pq.offer(seqToList(entry.getKey()));
            }
        }
        return pq.poll();
    }

    private void findAllSeqs(List<String> visits, int index, List<String> cur, Set<String> seqs) {
        if (cur.size() == 3) {
            String key = cur.toString();
            key = key.substring(1, key.length() - 1).replaceAll(" ", "");
            seqs.add(key);
            return;
        }
        if (index >= visits.size()) {
            return;
        }
        findAllSeqs(visits, index + 1, cur, seqs);
        cur.add(visits.get(index));
        findAllSeqs(visits, index + 1, cur, seqs);
        cur.remove(cur.size() - 1);
    }

    private List<String> seqToList(String seq) {
        List<String> res = new ArrayList();
        String[] sites = seq.split(",");
        for (String s : sites) {
            res.add(s);
        }
        return res;
    }
}
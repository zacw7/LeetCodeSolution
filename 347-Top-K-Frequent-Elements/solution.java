class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList();
        if (nums.length == 0 || k == 0) return ans;
        Map<Integer, Element> map = new HashMap();
        for (int n : nums) {
            Element e;
            if (map.containsKey(n)) e = map.get(n);
            else e = new Element(n);
            e.addFreq();
            map.put(n, e);
        }
        List<Element> list = new ArrayList(map.values());
        Collections.sort(list, (o1, o2) -> o2.freq - o1.freq);
        for (int i = 0; i < k; i++) {
            Element e = list.get(i);
            ans.add(e.val);
        }
        return ans;
    }

    class Element {
        int val, freq;
        Element(int val) {
            this.val = val;
            this.freq = 0;
        }
        void addFreq() {
            this.freq++;
        }
    }
}
class Solution {

    Map<String, Integer> indexMap;
    Map<String, String> abbrMap;
    Map<String, String> originMap;

    public List<String> wordsAbbreviation(List<String> dict) {
        if (dict == null || dict.isEmpty()) {
            return new ArrayList();
        }

        indexMap = new HashMap();
        abbrMap = new HashMap();
        originMap = new HashMap();

        for (int i = 0; i < dict.size(); i++) {
            String s = dict.get(i);
            indexMap.put(s, i);
            String abbr = abbreviate(s, 1);
            abbrMap.put(s, abbr);
            originMap.put(abbr, s);
        }
        List<String> abbrs = new ArrayList(abbrMap.values());
        Collections.sort(abbrs, (o1, o2) -> indexMap.get(originMap.get(o1)) - indexMap.get(originMap.get(o2)));
        return abbrs;
    }

    private String abbreviate(String s, int prefixLen) {
        if (s.length() - prefixLen - 1 <= 1) {
            return s;
        }
        String abbr = s.substring(0, prefixLen) + (s.length() - prefixLen - 1) + s.substring(s.length() - 1, s.length());
        if (originMap.containsKey(abbr)) {
            // clash
            String origin = originMap.get(abbr);
            if (abbrMap.get(origin).equals(abbr)) {
                String newAbbr = abbreviate(origin, prefixLen + 1);
                abbrMap.put(origin, newAbbr);
                originMap.put(newAbbr, origin);
            }
            abbr = abbreviate(s, prefixLen + 1);
        }
        return abbr;
    }
}
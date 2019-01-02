class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList();
        List<String> pathList = new ArrayList();
        Map<String, List<String>> fileMap = new HashMap();
        for (String p : paths) {
            String[] substrs = p.split(" ");
            String basePath = substrs[0] + '/';
            for (int i = 1; i < substrs.length; i++) {
                pathList.add(basePath + substrs[i]);
            }
        }
        for (String p : pathList) {
            String content = p.substring(p.indexOf('(') + 1, p.indexOf(')'));
            String fullPath = p.substring(0, p.indexOf('('));
            List<String> pList = fileMap.getOrDefault(content, new ArrayList());
            pList.add(fullPath);
            fileMap.put(content, pList);
        }
        for (List<String> pList : fileMap.values()) {
            if (pList.size() >= 2) {
                ans.add(pList);
            }
        }
        return ans;
    }
}
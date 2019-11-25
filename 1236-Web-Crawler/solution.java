/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visited = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.offer(startUrl);
        visited.add(startUrl);
        int endIdx = startUrl.indexOf('/', 8);
        String hostname = startUrl;
        if (endIdx >= 0) {
            hostname = startUrl.substring(0, endIdx);
        }
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String neigh : htmlParser.getUrls(cur)) {
                if (!visited.contains(neigh) && neigh.startsWith(hostname)) {
                    queue.offer(neigh);
                    visited.add(neigh);
                }
            }
        }
        return new ArrayList(visited);
    }
}
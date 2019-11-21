class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap(); // key: center.x + "#" + center.y + "#" + length
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                double c_x = (x1 + x2) / 2.0;
                double c_y = (y1 + y2) / 2.0;
                int len = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                String key = c_x + "#" + c_y + "#" + len;
                List<int[]> list = map.getOrDefault(key, new ArrayList());
                list.add(new int[]{x1, y1, x2, y2});
                map.put(key, list);
            }
        }
        double area = Double.MAX_VALUE;
        for (List<int[]> list : map.values()) {
            if (list.size() < 2) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                int x1 = list.get(i)[0], y1 = list.get(i)[1];
                for (int j = i + 1; j < list.size(); j++) {
                    int x2 = list.get(j)[0], y2 = list.get(j)[1];
                    int x3 = list.get(j)[2], y3 = list.get(j)[3];
                    area = Math.min(area, Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) * Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)));
                }
            }
        }
        return area == Double.MAX_VALUE ? 0 : area;
    }
}
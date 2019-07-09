class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> scoreMap = new HashMap();
        for (int[] item : items) {
            PriorityQueue<Integer> queue = scoreMap.getOrDefault(item[0], new PriorityQueue());
            queue.offer(item[1]);
            if (queue.size() > 5) {
                queue.poll();
            }
            scoreMap.put(item[0], queue);
        }
        List<int[]> avgList= new ArrayList();
        for (int id : scoreMap.keySet()) {
            PriorityQueue<Integer> queue = scoreMap.get(id);
            int sum = 0;
            while (!queue.isEmpty()) {
                sum += queue.poll();
            }
            avgList.add(new int[]{id, sum / 5});
        }
        return avgList.toArray(new int[avgList.size()][]);
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (char t : tasks) taskCount[t - 'A']++;
        Arrays.sort(taskCount);
        int times = 0;
        while (taskCount[25] > 0) {
            int i = 0;
            while (i <= n && taskCount[25 - i] > 0) {
                taskCount[25 - i]--;
                times++;
                i++;
            }
            Arrays.sort(taskCount);
            if (taskCount[25] == 0) break;
            times += n - i + 1;
        }
        return times;
    }
}
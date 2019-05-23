class Solution {
    // Two PriorityQueue
    // TC: O(NlogN)
    // SC: O(N)
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Project> unavailableProjects = new PriorityQueue<Project>((o1, o2) -> o1.capital - o2.capital);
        PriorityQueue<Project> availableProjects = new PriorityQueue<Project>((o1, o2) -> o2.profit - o1.profit);

        for (int i = 0; i < Profits.length; i++) {
            Project project = new Project(Profits[i], Capital[i]);
            if (project.capital <= W) {
                availableProjects.offer(project);
            } else {
                unavailableProjects.offer(project);
            }
        }
        while (k-- > 0) {
            while (!unavailableProjects.isEmpty() && unavailableProjects.peek().capital <= W) {
                availableProjects.offer(unavailableProjects.poll());
            }
            if (availableProjects.isEmpty()) {
                break;
            } else {
                W += availableProjects.poll().profit;
            }
        }
        return W;
    }

    class Project {
        int profit, capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
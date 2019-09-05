class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) {
            return 0;
        }
        int N = routes.length;
        Map<Integer, Set<Integer>> busMap = new HashMap();
        Set<Integer>[] routeSet = new Set[N];
        for (int i = 0; i < N; i++) {
            routeSet[i] = new HashSet();
            for (int stop : routes[i]) {
                Set<Integer> set = busMap.getOrDefault(stop, new HashSet());
                set.add(i);
                busMap.put(stop, set);
                routeSet[i].add(stop);
            }
        }
        boolean[] visitedRoute = new boolean[N];
        Set<Integer> visitedStop = new HashSet();
        Queue<Integer> queue = new LinkedList();
        visitedStop.add(S);
        for (int route : busMap.get(S)) {
            visitedRoute[route] = true;
            queue.offer(route);
        }
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curRoute = queue.poll();
                for (int nextStop : routeSet[curRoute]) {
                    if (nextStop == T) {
                        return res;
                    } else if (!visitedStop.contains(nextStop)) {
                        for (int nextRoute : busMap.get(nextStop)) {
                            if (!visitedRoute[nextRoute]) {
                                visitedRoute[nextRoute] = true;
                                queue.offer(nextRoute);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
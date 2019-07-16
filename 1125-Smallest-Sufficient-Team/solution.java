class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n_skills = req_skills.length, n_people = people.size();
        Map<String, Integer> skillMap = new HashMap();
        for (int i = 0; i < n_skills; i++) {
            skillMap.put(req_skills[i], i);
        }
        List<Integer>[] teams = new List[1 << n_skills];
        teams[0] = new ArrayList();
        for (int i = 0; i < n_people; i++) {
            int skill = 0;
            for (String s : people.get(i)) {
                skill |= (1 << skillMap.get(s));
            }
            for (int prev = 0; prev < teams.length; prev++) {
                int cur = prev | skill;
                if (teams[prev] == null || cur == prev) {
                    continue;
                }
                if (teams[cur] == null || teams[cur].size() > teams[prev].size() + 1) {
                    teams[cur] = new ArrayList(teams[prev]);
                    teams[cur].add(i);
                }
            }
        }
        List<Integer> suffTeam = teams[(1 << n_skills) - 1];
        int[] ans = new int[suffTeam.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = suffTeam.get(i);
        }
        return ans;
    }
}
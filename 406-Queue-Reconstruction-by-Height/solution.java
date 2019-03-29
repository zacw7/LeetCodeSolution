class Solution {
    public int[][] reconstructQueue(int[][] people) {
        for (int i = 0; i < people.length - 1; i++) {
            int minHeight = Integer.MAX_VALUE, minIdx = -1;
            for (int j = i; j < people.length; j++) {
                int curFront = 0;
                for (int f = i - 1; f >= 0; f--) {
                    if (people[f][0] >= people[j][0]) curFront++;
                }
                if (curFront == people[j][1] && people[j][0] < minHeight) {
                    minHeight = people[j][0];
                    minIdx = j;
                }
            }
            int tmpH = people[i][0], tmpK = people[i][1];
            people[i][0] = people[minIdx][0];
            people[i][1] = people[minIdx][1];
            people[minIdx][0] = tmpH;
            people[minIdx][1] = tmpK;
        }
        return people;
    }
}
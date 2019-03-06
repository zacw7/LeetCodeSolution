class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet();
        for (int c : candies) kinds.add(c);
        return (kinds.size() <= candies.length / 2) ? kinds.size() : candies.length / 2;
    }
}
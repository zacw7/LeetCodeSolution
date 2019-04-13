/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        int depth = maxDepth(nestedList);
        int[] ans = new int[depth];
        dfs(nestedList, depth, ans);
        int sum = 0;
        for (int n : ans) sum += n;
        return sum;
    }

    private int maxDepth(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        int depth = 0;
        for (NestedInteger ni : nestedList) {
            if (!ni.isInteger()) depth = Math.max(depth, maxDepth(ni.getList()));
        }
        return depth + 1;
    }

    private void dfs(List<NestedInteger> nestedList, int depth, int[] ans) {
        if (depth == 0) return;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) ans[depth - 1] += ni.getInteger() * depth;
            else dfs(ni.getList(), depth - 1, ans);
        }
    }
}
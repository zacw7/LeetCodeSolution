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
    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();
        if (s == null || s.length() == 0) {
            return res;
        }
        if (s.charAt(0) != '[') {
            res.setInteger(Integer.valueOf(s));
        } else {
            List<NestedInteger> list = res.getList();
            int prevComma = 0, bracket = 0;
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ',' || i == s.length() - 1) {
                    if (bracket == 0 && i > prevComma + 1) {
                        list.add(deserialize(s.substring(prevComma + 1, i)));
                        prevComma = i;
                    }
                } else if (c == '[') {
                    bracket++;
                } else if (c == ']') {
                    bracket--;
                }
            }
        }
        return res;
    }
}
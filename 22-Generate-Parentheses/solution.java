class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> results;
        string s = "(";
        int i = 0;
        if(n) {
            helper(s, n-1, i+1, results);
        }
        return results;
    }

    void helper(string s, int n, int i, vector<string> &results) {
        if(n > 0) {
            helper(s+"(", n-1, i+1, results);
            if(i>0) helper(s+")", n, i-1, results);
        } else if (n == 0){
            results.push_back(s.append(i, ')'));
        }
    }
};
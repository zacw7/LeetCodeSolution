class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> result;
        vector<int> combination;
        helper(n, k, 1, combination, result);
        return result;
    }
    
    void helper(int n, int k, int curN, vector<int> & combination, vector<vector<int>> & result) {
        if (combination.size() == k) {
            result.push_back(combination);
            return;
        }
        
        for(int i = curN; i <= n; ++i) {
            combination.push_back(i);
            helper(n, k, i + 1, combination, result);
            combination.erase(combination.end()-1);
            
        }
    }
};
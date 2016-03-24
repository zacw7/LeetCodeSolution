class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        vector<vector<int>> path(m, vector<int>(n,1));
        int i = 0, j = 0;

        for (i = 1; i < m; ++i)
            for (j = 1; j < n; ++j)
                path[i][j] = path[i-1][j] + path[i][j-1];

        return path[m-1][n-1];
    }
};
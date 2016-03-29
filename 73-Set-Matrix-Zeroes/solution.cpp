class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int rows = matrix.size();
        if(rows==0) return;
        int cols = matrix[0].size();
        if(cols==0) return;
        bool isFirstRowZero, isFirstColZero;
        isFirstRowZero = isFirstColZero = false;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    if(i==0) isFirstRowZero = true;
                    if(j==0) isFirstColZero = true;
                    if(i&&j) matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < cols; i++) {
            if(matrix[0][i] == 0)
                for(int j = 1; j < rows; j++)
                    matrix[j][i] = 0;
        }
        
        for(int i = 1; i < rows; i++) {
            if(matrix[i][0] == 0)
                for(int j = 1; j < cols; j++)
                   matrix[i][j] = 0;
        }
        
        if(isFirstRowZero)
            for(int i = 0; i < cols; i++)
                matrix[0][i] = 0;
                
        if(isFirstColZero)
            for(int i = 0; i < rows; i++)
                matrix[i][0] = 0;
    }
};
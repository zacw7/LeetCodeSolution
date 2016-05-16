class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end(), greater<int>());
        int size = coins.size();
        int coinCount = 0;
        while(amount) {
            int tempAmount = amount;
            for(int i = 0; i < size; i++) {
                if(amount >= coins[i]) {
                    amount -= coins[i];
                    coinCount++;
                    break;
                }
            }
            //if(tempAmount==amount) return -1;
        }
        return coins[0];
    }
};
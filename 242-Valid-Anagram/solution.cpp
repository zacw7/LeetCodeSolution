class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        int size = s.size();
        int anagramHelper[26] = {0};
        for(int i = 0; i < size; i++) {
            anagramHelper[s.at(i)-'a']++;
            anagramHelper[t.at(i)-'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(anagramHelper[i]) return false;
        }
        return true;
    }
};
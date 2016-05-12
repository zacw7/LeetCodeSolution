class Solution {
public:
    bool isValid(string s) {
        stack<char> brackets;
        int length = s.length();
        for(int i = 0; i < length; i++) {
            switch(s[i]) {
                case '(': 
                case '{':
                case '[':
                    brackets.push(s[i]);
                    break;
                case ')':
                    if(brackets.empty() || brackets.top()!='(') return false;
                    else brackets.pop();
                    break;
                case '}':
                    if(brackets.empty() || brackets.top()!='{') return false;
                    else brackets.pop();
                    break;
                case ']':
                    if(brackets.empty() || brackets.top()!='[') return false;
                    else brackets.pop();
                    break;
            }
        }
        if(brackets.empty()) return true;
        return false;
    }
};
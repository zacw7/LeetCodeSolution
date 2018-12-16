// use stack
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack();
        Stack<Character> stackT = new Stack();
        int lenS = S.length(), lenT = T.length();
        for (int i = 0; i < lenS; i++) {
            if ('#' == S.charAt(i)) {
                if (!stackS.isEmpty()) stackS.pop();
            } else {
                stackS.push(S.charAt(i));
            }
        }
        for (int i = 0; i < lenT; i++) {
            if ('#' == T.charAt(i)) {
                if (!stackT.isEmpty()) stackT.pop();
            } else {
                stackT.push(T.charAt(i));
            }
        }
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (!stackS.pop().equals(stackT.pop())) return false;
        }
        return stackS.isEmpty() && stackT.isEmpty();
    }
}

// 2 pointers
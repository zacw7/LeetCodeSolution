class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String[] dirs = path.split("/");
        for (String d : dirs) {
            if (d.equals(".") || d.equals("")) {
                continue;
            } else if (d.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(d);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
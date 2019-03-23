class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> dirStack = new Stack();
        for (String dir : directories) {
            if (dir.length() == 0 || dir.equals(".")) continue;
            if (dir.equals("..")) {
                if (!dirStack.isEmpty()) dirStack.pop();
            } else {
                dirStack.push(dir);
            }
        }
        if (dirStack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        Stack<String> reverseStack = new Stack();
        while (!dirStack.isEmpty()) reverseStack.push(dirStack.pop());
        while (!reverseStack.isEmpty()) sb.append("/").append(reverseStack.pop());
        return sb.toString();
    }
}
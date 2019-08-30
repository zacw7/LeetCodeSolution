class FileSystem {

    FileNode root;

    public FileSystem() {
        this.root = new FileNode("", 0);
    }

    public boolean create(String path, int value) {
        FileNode node = root;
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length - 1; i++) {
            if (node.children.containsKey(parts[i])) {
                node = node.children.get(parts[i]);
            } else {
                return false;
            }
        }
        String last = parts[parts.length - 1];
        if (node.children.containsKey(last)) {
            return false;
        }
        node.children.put(last, new FileNode(last, value));
        return true;
    }

    public int get(String path) {
        FileNode node = root;
        String[] parts = path.split("/");
        for (int i = 1; i < parts.length; i++) {
            if (node.children.containsKey(parts[i])) {
                node = node.children.get(parts[i]);
            } else {
                return -1;
            }
        }
        return node.value;
    }

    class FileNode {
        int value;
        String path;
        Map<String, FileNode> children;

        FileNode(String path, int value) {
            this.path = path;
            this.value = value;
            this.children = new HashMap();
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.create(path,value);
 * int param_2 = obj.get(path);
 */
class FileSystem {

    private FileTreeNode root;

    public FileSystem() {
        this.root = new FileTreeNode(false);
    }

    public List<String> ls(String path) {
        List<String> res = null;
        String[] paths = path.split("/");
        FileTreeNode node = root;
        for (String p : paths) {
            if (p == null || p.length() == 0) {
                continue;
            }
            node = node.pathMap.get(p);
            if (node.isFile) {
                res = new ArrayList();
                res.add(p);
            }
        }
        if (res == null) {
            res = new ArrayList(node.pathMap.keySet());
        }
        return res;
    }

    public void mkdir(String path) {
        String[] paths = path.split("/");
        FileTreeNode node = root;
        for (String p : paths) {
            if (p == null || p.length() == 0) {
                continue;
            }
            if (!node.pathMap.containsKey(p)) {
                FileTreeNode nNode = new FileTreeNode(false);
                node.pathMap.put(p, nNode);
            }
            node = node.pathMap.get(p);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = filePath.split("/");
        FileTreeNode node = root;
        for (int i = 0; i < paths.length; i++) {
            String p = paths[i];
            if (p == null || p.length() == 0) {
                continue;
            }
            if (!node.pathMap.containsKey(p)) {
                if (i == paths.length - 1) {
                    FileTreeNode nNode = new FileTreeNode(true);
                } else {
                    FileTreeNode nNode = new FileTreeNode(false);
                }
                FileTreeNode nNode = new FileTreeNode(true);
                node.pathMap.put(p, nNode);
            }
            node = node.pathMap.get(p);
            if (i == paths.length - 1) {
                node.content = node.content + content;
            }
        }
    }

    public String readContentFromFile(String filePath) {
        String[] paths = filePath.split("/");
        FileTreeNode node = root;
        for (String p : paths) {
            if (p == null || p.length() == 0) {
                continue;
            }
            if (!node.pathMap.containsKey(p)) {
                FileTreeNode nNode = new FileTreeNode(false);
                node.pathMap.put(p, nNode);
            }
            node = node.pathMap.get(p);
        }
        return node.content;
    }

    class FileTreeNode {
        boolean isFile;
        String content;
        TreeMap<String, FileTreeNode> pathMap;

        FileTreeNode(boolean isFile) {
            this.isFile = isFile;
            this.content = null;
            this.pathMap = null;
            if (!isFile) {
                this.pathMap = new TreeMap<String, FileTreeNode>((o1, o2) -> o1.compareTo(o2));
            } else {
                this.content = "";
            }
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
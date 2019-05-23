# 588. Design In-Memory File System

**Hard**

[Original Page](https://leetcode.com/problems/design-in-memory-file-system/)

Design an in-memory file system to simulate the following functions:

`ls`: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names __in this directory__. Your output (file and directory names together) should in __lexicographic order__.

`mkdir`: Given a __directory path__ that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

`addContentToFile`: Given a __file path__ and __file content__ in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to __append__ given content to original content. This function has void return type.

`readContentFromFile`: Given a __file path__, return its __content__ in string format.

##### Example:
```
Input: 
["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
[[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

Output:
[null,[],null,null,["a"],"hello"]
```

Explanation:
![](https://assets.leetcode.com/uploads/2018/10/12/filesystem.png)

##### Note:
1. You can assume all file or directory paths are absolute paths which begin with `/` and do not end with `/` except that the path is just `"/"`.
2. You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
3. You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.

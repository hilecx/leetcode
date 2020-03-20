import java.util.*;

public class A0720LongestWordinDictionary2 {
    //答案中的更优解，比自己写的快，但是trie结构学到了
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            populate(word, root);
        }
        findLongest(root,new StringBuilder());
        return res;
    }


    private void populate(String word, TrieNode root) {
        int idx = 0;
        while (idx < word.length()) {
            int i = word.charAt(idx++) - 'a';
            if (root.nexts[i] == null) root.nexts[i] = new TrieNode();
            root = root.nexts[i];
        }
        root.isWord = true;
    }

    String res = "";
    private void findLongest(TrieNode root, StringBuilder path) {
        if (path.length() > res.length()) {
            res = path.toString();
        }
        for (int i = 0; i < 26; i++) {
            if (root.nexts[i] != null && root.nexts[i].isWord) {
                path.append((char)('a' + i));
                findLongest(root.nexts[i],path);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//用这个结构保存 一个parent对应多个leaf的结构
    class TrieNode {
        TrieNode[] nexts;
        boolean isWord;
        TrieNode () {
            this.nexts = new TrieNode[26];
            this.isWord = false;
        }
    }


    public static void main(String[] args) {
//        System.out.println("abc".substring(0, 2));
        System.out.println(new A0720LongestWordinDictionary2().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(new A0720LongestWordinDictionary2().longestWord(new String[]{"ab", "abc"}));
    }
}

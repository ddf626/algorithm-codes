package ddf.p15_trie;

public class C78_TrieTree {

    TrieNode head;

    public C78_TrieTree() {
        this.head = new TrieNode();
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = head;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new TrieNode();
            }
            cur = cur.next[c - 'a'];
            cur.pass++;
        }
        cur.end++;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = head;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.end > 0;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        TrieNode cur = head;
        for (char c : cs) {
            if (cur.next[c - 'a'] == null) {
                return false;
            }
            cur = cur.next[c - 'a'];
        }
        return true;
    }

    public static class TrieNode {
        int pass;
        int end;
        TrieNode[] next;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.next = new TrieNode[26];
        }
    }


}

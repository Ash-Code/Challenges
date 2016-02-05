package theory.datastructures;

import java.util.*;

/**
 * Created by ashwin on 24/1/16.
 */
public class NewTrie {

    private class TrieNode {
        public char v;
        java.util.ArrayList<String> prefixes;
        boolean isEnd;
        TrieNode[] childs;

        public TrieNode(char v) {
            this.v = v;
            childs = new TrieNode[26];
            isEnd = false;
            prefixes = new java.util.ArrayList<>();
        }
    }


    TrieNode root;

    public NewTrie() {
        root = new TrieNode('\0');
    }

    public void add(String word) {
        //add a word using crawl
        int p = 0;
        TrieNode curr = root;
        while (p < word.length()) {
            char c = word.charAt(p);
            if (curr.childs[c - 'a'] == null) {
                curr.childs[c - 'a'] = new TrieNode(c);
            }
            curr.prefixes.add(word);
            curr = curr.childs[c - 'a'];
            p++;
            if (p == word.length())
                curr.isEnd = true;
        }
        //set end
        //update prefixes
    }

    public java.util.ArrayList<String> getWordsWithPrefix(String prefix) {
        TrieNode curr = root;
        int p = 0;
        while (p < prefix.length()) {
            char c = prefix.charAt(p);
            if (curr.childs[c - 'a'] == null)
                return null;
            curr = curr.childs[c - 'a'];
            p++;
            if (p == prefix.length())
                return curr.prefixes;
        }
        return null;
        //traverse and return the prefixes array
    }

    public boolean findWord(String word) {
        //traverses till it finds the isEnd true at the word's end
        return false;
    }


    public static void main(String args[]) {
        Scanner ss = new Scanner(System.in);
        NewTrie temp = new NewTrie();
        temp.add("abcd");
        temp.add("abce");
        temp.add("abrt");
        temp.add("acdb");

        System.out.println(temp.getWordsWithPrefix("ac"));
        //System.out.println(b.replace("-> ",""));
    }
}

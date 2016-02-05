package theory.datastructures;

import java.util.HashMap;

public class TrieNode {
    private char val;
    private HashMap<Character, TrieNode> childs;
    private boolean isEnd;

    public TrieNode(char val) {
        this.val = val;
        this.isEnd = false;
        childs = new HashMap<Character, TrieNode>();
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public HashMap<Character, TrieNode> getChilds() {
        return childs;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }


}

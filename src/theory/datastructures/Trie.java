package theory.datastructures;

import java.util.HashMap;

public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode((char) 0);
	}

	public void add(String input) {
		TrieNode crawl = root;
		HashMap<Character, TrieNode> options;
		for (int level = 0; level < input.length(); level++) {
			char curr = input.charAt(level);
			options = crawl.getChilds();
			if (options.containsKey(curr)) {
				crawl = options.get(curr);
			} else {
				options.put(curr, new TrieNode(curr));
				crawl = options.get(curr);
			}
		}
		crawl.setEnd(true);

	}

	public String longestPrefix(String input) {
		String result = "";
		TrieNode crawl = root;
		HashMap<Character, TrieNode> options;
		int prevMatch = 0;// we need this to have prefixes as words, records
							// previous matched words, only updated at isEnd
		for (int level = 0; level < input.length(); level++) {
			char curr = input.charAt(level);
			options = crawl.getChilds();
			if (options.containsKey(curr)) {
				result += curr;
				crawl = options.get(curr);
				if(crawl.isEnd()){
					prevMatch=level+1;
				}
			} else {
				break;
			}
		}

		return result;
	}

    public static void main(String args[]){
        Trie temp=new Trie();
        temp.add("abcd");
        temp.add("cbdc");
        temp.add("abdc");
        System.out.println(temp.longestPrefix("ax"));
    }

}

public class TtieDesign {
	public static void main(String args[]){
		Trie tree = new Trie();
		tree.insert("anchor");
		tree.insert("andy");
		tree.insert("ant");
	}

}

class TrieNode {
	public static final int alphat_size = 26;// java中的全局变量是这样设置的吗
	// Initialize your data structure here.
	TrieNode children[];// = new TrieNode[26];
	boolean partern;
	boolean leaf;// 这里的访问权限应该是怎样的

	public TrieNode() {
		children = new TrieNode[alphat_size];// 0代表的是a
		partern = false;
		leaf = false;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		char[] toChar = word.toCharArray();
		TrieNode currentNode;
		int i;// 需不需要对i的长度有所限制
		for (i= 0, currentNode = root; i < toChar.length && currentNode.children[toChar[i] - 'a'] != null; currentNode = currentNode.children[toChar[i++] - 'a'])
			;
		if (i < toChar.length) {
			if(currentNode.leaf == true)
				currentNode.leaf = false;
			while (i < toChar.length) {
				currentNode.children[toChar[i] - 'a'] = new TrieNode();
				currentNode = currentNode.children[toChar[i++] - 'a'];
			}
			currentNode.leaf = true;
		}
		currentNode.partern = true;

	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		char[] toChar = word.toCharArray();
		TrieNode currentNode;
		int i = 0;// 需不需要对i的长度有所限制
		for (currentNode = root; i < toChar.length && currentNode.children[toChar[i] - 'a'] != null; currentNode = currentNode.children[toChar[i++] - 'a'])
			;
		if (i == toChar.length) {
			if(currentNode.partern == true)
				return true;
			else
				return false;
		}else{
			return false;
		}

	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		char[] toChar = prefix.toCharArray();
		TrieNode currentNode;
		int i = 0;// 需不需要对i的长度有所限制
		for (currentNode = root; i < toChar.length && currentNode.children[toChar[i] - 'a'] != null; currentNode = currentNode.children[toChar[i++] - 'a'])
			;
		if (i == toChar.length) {
			return true;
		}else{
			return false;
		}

	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
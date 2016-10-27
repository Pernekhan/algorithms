import java.util.HashMap;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!currentNode.hasPathTo(c)) {
                currentNode.addNextLetter(c);
            }
            currentNode = currentNode.getNextNode(c);
        }
        currentNode.setEndOfWord(true);
    }

    public boolean exists(String s) {
        TrieNode currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            currentNode = currentNode.getNextNode(s.charAt(i));
            if (currentNode == null) {
                return false;
            }
        }
        return currentNode.isEndOfWord();
    }

    private class TrieNode {
        private HashMap<Character, TrieNode> to;
        private boolean isEndOfWord;

        public TrieNode() {
            to = new HashMap<>();
            isEndOfWord = false;
        }

        public boolean hasPathTo(char letter) {
            return to.containsKey(letter);
        }

        public TrieNode getNextNode(char letter) {
            if (hasPathTo(letter)) {
                return to.get(letter);
            }
            return null;
        }

        public void setEndOfWord(boolean isEndOfWord) {
            this.isEndOfWord = isEndOfWord;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void addNextLetter(char letter) {
            to.put(letter, new TrieNode());
        }
    }

}


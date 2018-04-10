import java.util.HashMap;
import java.util.Map;

public class Trie {

    public class TrieNode{
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode(){
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    /*
    * Insert into TrieNode Iteratively
    *
    * */

    public void insert(String word){

        TrieNode current = root;

        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    /*
    * Search Trie Iteratively.
    *
    * return - true if word is found
    *
    * */

    public boolean search(String word){
        TrieNode current = root;

        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.endOfWord;
    }

    /*
    *
    * Delete word from Trie
    *
    * */

    public void delete(String word){
        delete(word, root, 0);
    }

    public boolean delete(String word, TrieNode current, int index){

        if(index == word.length()){

            // When end of the word is reached, then only delete if current.endOfWord is true
            if(!current.endOfWord){
                return false;
            }

            current.endOfWord = false;

            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        // Now get the node, where this character exists
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }

        // Now, Recurse with the current node
        boolean shouldDeleteCurrentNode = delete(word, node, index + 1);

        // If true, then delete the mapping of the character and trienode reference from the map
        if(shouldDeleteCurrentNode){
            current.children.remove(ch);

            // just return true if no more mappings are left in the map
            return current.children.size() == 0;
        }

        return false;

    }



    public static void main(String[] args){

    }
}

/**
 * Created by i_amg on 10-10-2016.
 */



/**
 * <b>IDeserve <br>
 * <a href="https://www.youtube.com/c/IDeserve">https://www.youtube.com/c/IDeserve</a>
 * Construct a trie. Do insert, search and delete operations.
 * @author Nilesh
 */


public class Trie {

    // we are only dealing with keys with chars 'a' to 'z'
    final static int ALPHABET_SIZE = 26;
    final static int NON_VALUE = -1;

    class TrieNode
    {
        boolean isLeafNode;
        int value;

        TrieNode[] children;


        TrieNode(boolean isLeafNode, int value)
        {
            this.value = value;
            this.isLeafNode = isLeafNode;
            children = new TrieNode[ALPHABET_SIZE];
        }

        public void markAsLeaf(int value)
        {
            this.isLeafNode = true;
            this.value = value;
        }

        public void unMarkAsLeaf()
        {
            this.isLeafNode = false;
            this.value = NON_VALUE;
        }

    }

    TrieNode root;
    Trie()
    {
        this.root = new TrieNode(false, NON_VALUE);
    }

    private int getIndex(char ch)
    {
        return ch - 'a';
    }

    public int search(String key)
    {
        // null keys are not allowed
        if (key == null)
        {
            return NON_VALUE;
        }

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while ((currentNode != null) && (charIndex < key.length()))
        {
            int childIndex = getIndex(key.charAt(charIndex));

            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                return NON_VALUE;
            }
            currentNode = currentNode.children[childIndex];

            charIndex += 1;

        }

        if (currentNode != null)
        {
            return currentNode.value;
        }

        return NON_VALUE;
    }

    public void insert(String key, int value)
    {
        // null keys are not allowed
        if (key == null) return;

        key = key.toLowerCase();

        TrieNode currentNode = this.root;
        int charIndex = 0;

        while (charIndex < key.length())
        {
            int childIndex = getIndex(key.charAt(charIndex));

            if (childIndex < 0 || childIndex >= ALPHABET_SIZE)
            {
                System.out.println("Invalid Key");
                return;
            }

            if (currentNode.children[childIndex] == null)
            {
                currentNode.children[childIndex] = new TrieNode(false, NON_VALUE);
            }

            currentNode = currentNode.children[childIndex];
            charIndex  += 1;
        }

        // mark currentNode as leaf
        currentNode.markAsLeaf(value);
    }

    private boolean hasNoChildren(TrieNode currentNode)
    {
        for (int i = 0; i < currentNode.children.length; i++)
        {
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level)
    {

        boolean deletedSelf = false;

        if (currentNode == null)
        {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        // base case: if we have reached at the node which points to the alphabet at the end of the key.
        if (level == length)
        {
            // if there are no nodes ahead of this node in this path
            // then we can delete this node
            if (hasNoChildren(currentNode))
            {
                currentNode = null;
                deletedSelf = true;
            }
            // if there are nodes ahead of this node in this path
            // then we cannot delete this node. We simply unmark this as leaf
            else
            {
                currentNode.unMarkAsLeaf();
                deletedSelf = false;
            }
        }
        else
        {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);

            if (childDeleted)
            {
                // tricky
                // making children pointer also null: since child is deleted
                 currentNode.children[getIndex(key.charAt(level))] = null;

                // if this is leaf node that means this is part of another key
                // and hence we can not delete this node and it's parent path nodes
                if (currentNode.isLeafNode)
                {
                    deletedSelf = false;
                }
                // if childNode is deleted but if this node has more children then this node must be part of another key.
                // we cannot delete this node
                else if (!hasNoChildren(currentNode))
                {
                    deletedSelf = false;
                }
                // else safely delete this node
                else
                {
                    currentNode = null;
                    deletedSelf = true;
                }
            }
            else
            {
                deletedSelf = false;
            }
        }

        return deletedSelf;
    }

    public void delete(String key)
    {
        if ((root == null) || (key == null))
        {
            System.out.println("Null key or Empty trie error");
            return;
        }

        deleteHelper(key, root, key.length(), 0);
        return;
    }


    public static void main(String[] args)
    {
        Trie tr = new Trie();

        // tr.insert("word", 5);
        tr.insert("xyz", 5);
        tr.insert("xyzb", 8);

        tr.insert("abb", 9);
        tr.insert("abc", 1);


        tr.delete("abc");
        System.out.println("Deleted key \"abc\"");

        String key = "abc";
        int value = tr.search(key);

        if (value != NON_VALUE)
        {
            System.out.println("Key-value pair retrieved");
            System.out.println("for key \"" + key + "\" value is " + value);
        }
    }
}


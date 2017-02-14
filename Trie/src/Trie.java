import java.lang.String;

/**
 * Created by i_amg on 29-09-2016.
 */
class TrieNode
{
    Integer value;
    TrieNode[] nodes = new TrieNode[26];
}
class Trr {
    TrieNode root;

    public Trr() {
        root = new TrieNode();
    }

    void Insert(String w, Integer v) {
        TrieNode p = root;
        for (int i = 0; i < w.length(); i++) {
            int index = w.charAt(i) - 'a';
            if (p.nodes[index] == null) {
                p.nodes[index] = new TrieNode();
            }

            p = p.nodes[index];
        }

        p.value = v;
    }

    int Search(String w)
    {
        if(w == null)
            return -1;
        TrieNode curr = root;
        for(int i = 0; i < w.length() && curr != null; i++)
        {
            int index = w.charAt(i) - 'a';

            curr = curr.nodes[index];
        }

        if(curr != null)
        {
            return curr.value;
        }
        else
        {
            return -1;
        }

    }

}

public class Trie
{

    public static void main(String[] args)
    {
         Trr obj = new Trr();
         obj.Insert("simran", 10);
         obj.Insert("harman", 20);
         obj.Insert("sartaj", 30);
         obj.Insert("rajwinder", 40);
         int value = obj.Search("rajwind");
        System.out.println(value);
    }


}


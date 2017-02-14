/**
 * Created by i_amg on 09-10-2016.
 */
class TrieNode
{
    Integer value;
    TrieNode[] nodes = new TrieNode[26];
}
class Trie
{
    TrieNode root;
    public Trie(){root = new TrieNode();}
    public void Insert(String w, int value)
    {
        if(w == null || w.length() == 0) {
            System.out.println("Cannot bbe inserted");
            return;
        }

        TrieNode curr = root;
        for(int i = 0; i < w.length(); i++)
        {
            int index = w.charAt(i) - 'a';
            if(curr.nodes[index] == null)
            {
                curr.nodes[index] = new TrieNode();
            }

            curr = curr.nodes[index];

        }

        curr.value = value;
    }

    public int Search(String w)
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
            if(curr.value != null)
            return curr.value;
            else
                return -1;
        }
        else
        {
            return -1;
        }
    }

    public String   LongestMatchSubstring(String w)
    {
        if(w == null)
            return null;
        String LongestMatched = "";
        String MatchedTravled = "";
        TrieNode curr = root;
        for(int i = 0; i < w.length() && curr != null; i++)
        {
            int index = w.charAt(i) - 'a';
            curr = curr.nodes[index];
            if(curr != null)
            {
                MatchedTravled += w.charAt(i);
                if(curr.value != null)
                {
                    LongestMatched = MatchedTravled;
                }
            }

        }

        return LongestMatched;
    }
}
public class main
{
    public static void main(String[] args)
    {
        Trie obj = new Trie();
        obj.Insert("simran", 12);
        obj.Insert("harman", 20);
        obj.Insert("manjit", 30);
        obj.Insert("grewal", 40);
        obj.Insert("simranjit", 40);

       //int value = obj.Search(null);
        //System.out.println(value);

      String L =  obj.LongestMatchSubstring("simranjit");
        System.out.println(L);
    }

}

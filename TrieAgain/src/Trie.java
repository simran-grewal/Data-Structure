import javax.crypto.SealedObject;

/**
 * Created by i_amg on 12-10-2016.
 */
class TrieFun
{
    private class TrieNode
    {
        Integer value;
        TrieNode[] nodes = new TrieNode[26];
    }
    TrieNode root;
    public TrieFun()
    {
        root = new  TrieNode();
    }

    void Insert(String w, Integer value)
    {
        TrieNode curr = root;
        if(w.length() == 0 || w == null || value == null)
        {
            System.out.println("cannot Insert");
            return;
        }

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
        int  Result = -1;
        if(w.length() == 0 || w == null)
        {
            System.out.println("Incorrect Input");
        }
        TrieNode curr = root;
        for(int i = 0; i < w.length() && curr != null; i++)
        {
            int Index = w.charAt(i) - 'a';
            curr = curr.nodes[Index];
        }

        if(curr != null)
        {
            if(curr.value != null)
            {
                Result = curr.value;
            }
            else
            {
                System.out.println("No value found");
            }
        }
        else
        {
            System.out.println("Word Not Found");
        }
        return Result;
    }
    private boolean hasNoChild(TrieNode curr)
    {
        for(int i = 0; i < curr.nodes.length; i++)
        {
            if(curr.nodes[i] != null)
                return false;
        }

        return true;
    }
    private boolean DeleteHelper(String w, TrieNode curr, int Length, int Level)
    {
        boolean selfDelete = false;
        if(curr == null)
        {
            System.out.println("Word Not Found");
            return selfDelete;
        }

        if(Length == Level)
        {
            if(hasNoChild(curr))
            {
                curr = null;
                selfDelete = true;
            }
            else
            {
                curr.value = null;
                selfDelete = false;
            }
        }
        else
        {
            int index = w.charAt(Level) - 'a';
            TrieNode child = curr.nodes[index];
            boolean ToDelete = DeleteHelper(w, child, Length, Level + 1);
            if(ToDelete)
            {
                index = w.charAt(Level) - 'a';
                curr.nodes[index] = null;

                if(curr.value != null)
                {
                    selfDelete = false;
                }
                else if(!hasNoChild(curr))
                {
                    selfDelete = false;
                }
                else
                {
                    curr = null;
                    selfDelete  = true;
                }
            }
            else
            {
                selfDelete = false;
            }
        }
        return selfDelete;
    }
    public void Delete(String w)
    {
        if(w == null|| w.length() == 0)
        {
            System.out.println("Input Incorrect");
        }
        DeleteHelper(w, root, w.length(), 0);
    }
}
public class Trie
{
    public static void main(String[] args)
    {
        TrieFun obj = new TrieFun();
        obj.Insert("abc", 5);
        obj.Insert("abb", 10);
        obj.Insert("abcde", 33);
        System.out.println(obj.Search("abc"));
        System.out.println(obj.Search("abcde"));

        obj.Delete("abcde");
        System.out.println(obj.Search("abcde"));
        System.out.println(obj.Search("abc"));


    }
}

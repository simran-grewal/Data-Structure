import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by i_amg on 07-10-2016.
 */
class Node1
{
    int data;
    Node1 left;
    Node1 right;
    public Node1(int data)
    {
        this.data = data;
    }
}
class Bst
{
    Node1 root = null;
    void Insert_Element(int data)
    {
       root = Insert_Element(root, data);
    }

    Node1 Insert_Element(Node1 root,int data)
    {
        if(root == null)
            return new Node1(data);
        if(data < root.data)
        {
            root.left = Insert_Element(root.left, data);
        }
        else
        {
            root.right = Insert_Element(root.right, data);
        }

        return root;
    }

    private class QueueEntry
    {
        Node1  root;
        int HoriDis;
        public QueueEntry(Node1 root, int horiDis)
        {
            this.root = root;
            this.HoriDis = horiDis;
        }
    }
    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    void  Level()
    {
        Level(root);
    }
    void Level(Node1 root)
    {
        Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
        queue.add(new QueueEntry(root, 0));
        while (!queue.isEmpty())
        {
            QueueEntry curr = queue.remove();
            Integer Map_Entry = map.get(curr.HoriDis);
        }
    }

}
public class Tp
{
    public static void main(String[] args)
    {
        Bst obj = new Bst();
        obj.Insert_Element(9);
        obj.Insert_Element(8);
        obj.Insert_Element(11);
        obj.Insert_Element(10);
        obj.Insert_Element(2);
        obj.Insert_Element(1);
        obj.Insert_Element(3);
        obj.Insert_Element(4);
        obj.Insert_Element(5);
        obj.Insert_Element(6);
        obj.Insert_Element(7);

        obj.Level();
    }
}

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.*;

/**
 * Created by i_amg on 07-10-2016.
 */
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;

    }
}

class View
{
    Node root = null;

    void Insert_Element(int data) {
        root = Insert_Element(root, data);
    }

    Node Insert_Element(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data) {
            root.left = Insert_Element(root.left, data);
        }
        if (data > root.data) {
            root.right = Insert_Element(root.right, data);
        }

        return root;
    }
    void LevelOrder()
    {
        LevelOrder(root);
    }

    class QueueEntry
    {
        Node root;
        int HorizontalDistance;
        public QueueEntry(Node root, int hr)
        {
            this.root = root;
            this.HorizontalDistance = hr;
        }
    }
    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

    void LevelOrder(Node root)
    {
        Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
        queue.add(new QueueEntry(root, 0));
        while(!queue.isEmpty())
        {
            QueueEntry current = queue.remove();
            Integer map_entry = map.get(current.HorizontalDistance);
            if(map_entry == null)
            {
                map.put(current.HorizontalDistance, current.root.data);
            }

            if(current.root.left != null)
            {
                queue.add(new QueueEntry(current.root.left, current.HorizontalDistance - 1));
            }
            if(current.root.right != null)
            {
                queue.add(new QueueEntry(current.root.right, current.HorizontalDistance + 1));
            }

        }

        print();
    }

    void print()
    {
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        //Set set = map.entrySet();
        //Iterator itr = set.iterator();
        while (itr.hasNext())
        {
            Map.Entry<Integer, Integer> res = itr.next();
            System.out.println(res.getValue());
        }
    }

}
public class TopView
{
    public static void main(String[] args)
    {
        View obj = new View();
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

        obj.LevelOrder();
    }
}

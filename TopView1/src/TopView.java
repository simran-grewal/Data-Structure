import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

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
class View {


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
    private class QueueEntry
    {
        Node root;
        int hD;
        public QueueEntry(Node root, int hD)
        {
            this.root = root;
            this.hD = hD;
        }
    }

    void LevelOrder() {
        LevelOrder(root);
    }
    Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

    void LevelOrder(Node root)
    {
        Queue<QueueEntry> queue = new LinkedList<QueueEntry>();
        queue.add(new QueueEntry(root, 0));
        while (!queue.isEmpty())
        {
            QueueEntry curr = queue.remove();
            Integer map_entry = map.get(curr.hD);
            if(map_entry == null)
            {
                map.put(curr.hD, curr.root.data);
            }


            if(curr.root.left != null)
            {
                queue.add(new QueueEntry(curr.root.left, curr.hD - 1));
            }
            if(curr.root.right != null)
            {
                queue.add(new QueueEntry(curr.root.right, curr.hD + 1));
            }

        }

        Print();
    }

    void Print()
    {
        Iterator<Map.Entry<Integer, Integer>> itr = map.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<Integer, Integer> nodeEntry = itr.next();
            System.out.print("  " + nodeEntry.getValue());
        }

    }

}
    public class TopView {
        public static void main(String[] args) {
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



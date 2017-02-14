import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by i_amg on 05-10-2016.
 */
class Node
{
    public int data;
    public Node left;
    public Node right;
    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Bst
{
    Node root = null;
    void Insert_Element(int data)
    {
        root = Insert_Element(root,data);
    }

    Node Insert_Element(Node root,int data)
    {
        if(root == null)
            return new Node(data);

        if(data < root.data)
        {
            root.left = Insert_Element(root.left, data);
        }
        if(data > root.data)
        {
            root.right = Insert_Element(root.right, data);
        }

        return root;
    }

    void BottomView()
    {
        BottomView(root);
    }

    void BottomView(Node root)
    {
        Set<Integer> s = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);s
        while (!queue.isEmpty())
        {

        }
    }

}
public class BottomView
{



    public static void main(String[] args)
    {
        Bst obj = new Bst();
        obj.Insert_Element(9);
        obj.Insert_Element(8);
        obj.Insert_Element(11);
        obj.Insert_Element(2);
        obj.Insert_Element(10);
        obj.Insert_Element(1);
        obj.Insert_Element(3);
        obj.Insert_Element(4);
        obj.Insert_Element(5);
        obj.Insert_Element(6);
        obj.Insert_Element(7);
        obj.BottomView():
    }
}

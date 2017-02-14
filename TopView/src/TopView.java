import java.util.*;

/**
 * Created by i_amg on 05-10-2016.
 */
class Node
{
    int data;
    Node left;
    Node right;
    int value;
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

    void LevelOrder()
    {
        LevelOrder(root);
    }
   void LevelOrder(Node  root)
    {

        Set<Integer> s = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        root.value = 0;
        s.add(root.value);
        System.out.println(root.data);
        while(!queue.isEmpty())
        {
            root = queue.poll();
          //  System.out.println(root.value);
            if(root.left != null)
            {
                root.left.value  = root.value - 1;

                if(!s.contains(root.left.value))
                {
                    System.out.println(root.left.data);
                    s.add(root.left.value);
                }
                queue.add(root.left);

            }
            if(root.right != null)
            {
                root.right.value = root.value + 1;
                if(!s.contains(root.right.value))
                {
                    System.out.println(root.right.data);
                    s.add(root.right.value);
                }
                queue.add(root.right);

            }
        }
    }
}
public class TopView
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

        obj.LevelOrder();

    }
}

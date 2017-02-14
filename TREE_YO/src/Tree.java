import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by i_amg on 21-09-2016.
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

    void PreOrder()
    {
        PreOrder(root);
    }
    void PreOrder(Node root)
    {
        if(root == null)
            return;

        PreOrder(root.left);
        System.out.println(root.data);
        PreOrder(root.right);
    }

    void LevelOrder()
    {
        LevelOrder(root);
    }
    void LevelOrder(Node root)
    {
        Queue<Node> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty())
        {
            root = queue.poll();
            System.out.println(root.data);
            if(root.left != null)
            {
                queue.add(root.left);
            }

            if(root.right != null)
            {
                queue.add(root.right);
            }
        }
    }

    void LevelOrder123()
    {
        Queue<Node>  queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        queue1.add(root);
        while (!(queue1.isEmpty()) || !(queue2.isEmpty()))
        {
            while (!queue1.isEmpty())
            {
                root = queue1.poll();
                System.out.print(root.data+" ");
                if(root.left != null)
                {
                    queue2.add(root.left);
                }
                if(root.right != null)
                {
                    queue2.add(root.right);
                }
            }

            System.out.println("\n");

            while (!queue2.isEmpty())
            {
                root = queue2.poll();
                System.out.print(root.data+" ");
                if(root.left != null)
                {
                    queue1.add(root.left);
                }
                if(root.right != null)
                {
                    queue1.add(root.right);
                }
            }
            System.out.println("\n");

        }
    }

    void ReverseLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            root = queue.poll();
            stack.push(root);
            if(root.right != null)
            {
                queue.add(root.right);
            }

            if(root.left != null)
            {
                queue.add(root.left);
            }

        }

        while (!stack.isEmpty())
        {
            root = stack.pop();
            System.out.println(root.data);
        }

    }

    void SpiralOrder()
    {
        Stack<Node> queue1 = new Stack<Node>();
        Stack<Node> queue2 = new Stack<Node>();

        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty())
        {
            while (!queue1.isEmpty())
            {
                root = queue1.pop();
                System.out.print(root.data + " ");
                if(root.left != null)
                {
                    queue2.push(root.left);
                }
                if(root.right != null)
                {
                    queue2.push(root.right);
                }
            }
            System.out.println("\n");
            while (!queue2.isEmpty())
            {
                root = queue2.pop();
                System.out.print(root.data + " ");
                if(root.right != null)
                {
                    queue1.push(root.right);
                }
                if(root.left != null)
                {
                    queue1.push(root.left);
                }
            }

            System.out.println("\n");

        }

    }
}
public class Tree
{
    public static void main(String[] args)
    {
        Bst obj = new Bst();
        obj.Insert_Element(15);
        obj.Insert_Element(10);
        obj.Insert_Element(25);
        obj.Insert_Element(12);
        obj.Insert_Element(8);
        obj.Insert_Element(20);
        obj.Insert_Element(30);
        obj.Insert_Element(35);
        obj.Insert_Element(40);
        obj.Insert_Element(34);
        //obj.PreOrder(); ..
       // obj.LevelOrder(); ..
      //  obj.LevelOrder123(); ..
       // System.out.println("\n");
     //   obj.ReverseLevelOrder(); ..

        obj.SpiralOrder();
    }
}

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

    void LeftView()
    {
        LeftView(root, 0);
    }
    int MaxLevel = -1;
    void LeftView(Node root, int Level)
    {
        if(root == null)
            return;
        if(Level > MaxLevel)
        {
            System.out.println(root.data);
            MaxLevel  = Level;
        }
        LeftView(root.left, Level + 1);
        LeftView(root.right, Level + 1);

    }
}
public class LeftView
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
        obj.LeftView();
    }
}

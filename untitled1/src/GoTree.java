/**
 * Created by i_amg on 16-01-2017.
 */
class Node
{
    Node left;
    Node right;
    int key;
    public Node(int data)
    {
        this.key = data;
        this.left = null;
        this.right = null;
    }
}
class Bst
{
    Node root;
    public Bst()
    {
        root = null;
    }

    public void Insert(int data)
    {
        root = Insert(root, data);
    }

    public Node Insert(Node root, int data)
    {
        if(root == null)
            return new Node(data);
        if(data < root.key)
        {
            root.left = Insert(root.left, data);

        }

        else
        {
            root.right = Insert(root.right, data);
        }


        return root;
    }

    public void Inorder()
    {
        Inorder(root);
    }

    public void Inorder(Node root)
    {
        if(root == null) return;
        Inorder(root.left);
        System.out.println(root.key);
        Inorder(root.right);
    }

    public void Delete(int data)
    {
        if(root != null)
        {
            root = Delete(root, data);
        }
    }
    public Node DelteMin(Node root)
    {
        if(root.left == null)
            return root;
       return DelteMin(root.left);
    }

    public Node Delete(Node root, int data)
    {
        if(data < root.key)
        {
            root.left = Delete(root.left, data);
        }
        if(data > root.key)
        {
            root.right = Delete(root.right, data);
        }

        else
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }
            if(root.left == null)
            {
                return root.right;
            }

            if(root.right == null)
                return root.left;
            else
            {
                Node temp = DelteMin(root.right);
                root.key = temp.key;
                Delete(root.right, temp.key);
            }
        }

        return root;
    }

}
public class GoTree
{
    public static void main(String[] args)
    {
        Bst tree = new Bst();
        tree.Insert(5);
        tree.Insert(3);
        tree.Insert(7);
        tree.Insert(2);
        tree.Insert(4);
        tree.Insert(6);
        tree.Insert(8);



        tree.Delete(5);
        tree.Inorder();
    }
}

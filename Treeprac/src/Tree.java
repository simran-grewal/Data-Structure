r/**
 * Created by i_amg on 19-09-2016.
 */
class   Node
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
class Bst {
    Node root = null;

    public void InsertNode(int data) {
        root = InsertNode(root, data);
    }

    Node InsertNode(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data) {
            root.left = InsertNode(root.left, data);
        } else {
            root.right = InsertNode(root.right, data);
        }

        return root;
    }

    void PreOrder() {
        if (root != null) {
            PreOrder(root);
        }
    }

    void PreOrder(Node root) {
        if (root == null) return;
        PreOrder(root.left);
        PreOrder(root.right);
        System.out.println(root.data);
    }

    void Delete(int data) {
        if (root != null) {
            root = Delete(root, data);
        }

    }

    Node FindMinimum(Node root)
    {
        if(root.left == null)
            return root;

        return FindMinimum(root.left);

    }
    Node Delete(Node root, int data) {
        if (root == null)
        {
            return  root;
        }

       else if(data < root.data)
        {
            root.left = Delete(root.left, data);
        }
      else  if(data > root.data)
        {
            root.right = Delete(root.right,data);
        }

        else
        {
            if(root.left == null && root.right == null)
            {
                root = null;
                return root;
            }
            else
            if(root.left == null)
            {
                return  root.right;
            }
            else
            if(root.right == null)
            {
                return  root.left;
            }
            else
            {
                Node temp = FindMinimum(root.right);
                root.data = temp.data;
                root.right = Delete(root.right, data);

            }


        }

        return root;

    }
/*
    boolean Search(int data)
    {
        Node curr = root;
        return Search(curr, data);
    }*/
/*
    boolean Search(Node root, int data)
    {
        if(root == null) return false;
        if(root.data == data)
            return true;
        if(root.data < data )
        {
            Search(root.right, data);
        }
        if(root.data > data)
        {
           // Search()
        }
    }*/

}
public class Tree
{
    public static void main(String[] args)
    {
        Bst obj = new Bst();
        obj.InsertNode(20);

        obj.InsertNode(15);
        obj.InsertNode(30);
        obj.InsertNode(25);
        obj.InsertNode(10);
        obj.InsertNode(8);


        //obj.PreOrder();

       // obj.Delete(20);


        obj.PreOrder();
/*
       if(obj.Search(25) == true)
       {
           System.out.println("Present");
       }
        else
       {
           System.out.println("Not Present");
       }*/

    }
}

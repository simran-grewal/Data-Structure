import com.sun.scenario.effect.impl.prism.ps.PPSOneSamplerPeer;

import java.util.Stack;

/**
 * Created by i_amg on 22-12-2016.
 */
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Bst {
    Node root = null;


    public void Insert(int data) {
        root = InsertIteratively(root, data);
    }

    /*
        public Node Insert(Node root, int data) {
            if (root == null)
                return new Node(data);

            if (data < root.data) {
                root.left = Insert(root.left, data);
            } else {
                root.right = Insert(root.right, data);
            }

            return root;
        }
    */
    void Inorder() {
        Inorder(root);
    }

    void Inorder(Node root) {
        if (root == null) return;
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);
    }


    Node InsertIteratively(Node root, int data) {
        Node node = new Node(data);
        if (root == null) {
            return node;
        }

        Node Parent = null;
        Node current = root;

        while (current != null) {
            Parent = current;

            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }

        }

        if (Parent.data < data) {
            Parent.right = node;
        } else {
            Parent.left = node;
        }
        return root;
    }

    void SameTree(Bst tree, Bst tree1) {
        Node r1 = tree.root;
        Node r2 = tree1.root;

        if (SameTree(r1, r2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    boolean SameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && SameTree(root1.left, root2.left) && SameTree(root1.right, root2.right);
    }

    void PostOrder() {
        PostOrderIteratively(root);
    }

    void PostOrderIteratively(Node root)
    {
        Stack<Node> stack1 = new Stack<Node>();
        Stack<Node> stack2 = new Stack<Node>();
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null)
            {
                stack1.push(root.left);
            }
            if(root.right != null)
            {
                stack1.push(root.right);
            }
        }

        while(!stack2.isEmpty())
        {
            System.out.println(stack2.pop().data);
        }

    }

    void PreOrder()
    {
        PreOrder(root);
    }

    void PreOrder(Node root)
    {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            root = stack.pop();
            System.out.println(root.data);

            if(root.right != null)
            {
                stack.push(root.right);
            }
            if(root.left != null)
            {
                stack.push(root.left);
            }
        }
    }

    void InorderIteratively()
    {
        if(root != null)
        {
            InorderIteratively(root);
        }

    }

    void InorderIteratively(Node root)
    {
        Stack<Node> stack = new Stack<Node>();
        while (true)
        {
            if(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                if(stack.isEmpty()) break;

                root = stack.pop();
                System.out.println(root.data);

                root = root.right;
            }
        }
    }

    void Height()
    {
        System.out.println(Height(root));
    }

    int Height(Node root)
    {
        if(root == null) return 0;

        int l = Height(root.left);
        int r = Height(root.right);

        if(l > r)
            return l + 1;
        else
            return r + 1;
    }

    void Size()
    {
        System.out.println(Size(root));
    }

    int Size(Node root)
    {
        if(root == null) return 0;

        return  Size(root.left) + 1 + Size(root.right);
    }
}

public class Tree
{
    public static void main(String[] args)
    {
        Bst tree = new Bst();
        tree.Insert(10);
        tree.Insert(8);
        tree.Insert(20);
        tree.Insert(6);
        tree.Insert(9);
        tree.Insert(15);
        tree.Insert(25);
        tree.Insert(5);

        Bst tree1 = new Bst();
        tree1.Insert(10);
        tree1.Insert(8);
        tree1.Insert(20);
        tree1.Insert(6);
        tree1.Insert(9);
        tree1.Insert(15);
        tree1.Insert(25);
        tree1.Insert(5);

        //tree.SameTree(tree, tree1);
       // tree.Inorder();
       // tree.PostOrder();
        //tree.PreOrder();
     //   tree.InorderIteratively();
        tree.Height();
        tree.Size();


    }
}

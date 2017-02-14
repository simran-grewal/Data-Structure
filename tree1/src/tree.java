import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by i_amg on 16-09-2016.
 */
 class Node
{
   public int key;
    public Node right;
   public Node left;

    public Node(int key)
    {
        this.key = key;
        this.right = this.left = null;
    }
}
class abc {
    Node root = null;

    void Insert(int data) {
        root = Insert(root, data);
    }

    Node Insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.key) {
            root.left = Insert(root.left, key);
        } else {
            root.right = Insert(root.right, key);
        }

        return root;
    }

    void PreOrder() {
        PreOrder(root);
    }

    void PreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.key);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    void PostOrder() {
        PostOrder(root);
    }

    void PostOrder(Node root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.key);
    }

    void InsertIteratively(int data) {
        root = InsertIteratively(root, data);
    }

    Node InsertIteratively(Node root, int data) {
        Node newnode = new Node(data);
        if (root == null) {
            return newnode;
        }
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (current.key <= data) {
                current = current.right;
            } else {
                current = current.left;
            }

        }

        if (data < parent.key) {
            parent.left = newnode;
        } else {
            parent.right = newnode;
        }

        return root;
    }

    void DeleteMinimum() {
        root = DeleteMinimum(root);
    }

    Node DeleteMinimum(Node root) {
        if (root.left == null) {
            return root.right;
        }

        root.left = DeleteMinimum(root.left);

        return root;
    }

    void DeleteMaximum() {
        root = DeleteMaximum(root);
    }

    Node DeleteMaximum(Node root) {
        if (root.right == null) {
            return root.left;
        }

        root.right = DeleteMaximum(root.right);

        return root;
    }


    int Size() {
        return Size(root);
    }

    int Size(Node root) {
        if (root == null) return 0;

        return Size(root.left) + Size(root.right) + 1;
    }

    void Height() {
        System.out.println(Height(root));
    }

    int Height(Node root) {
        if (root == null) return 0;
        int l = Height(root.left);
        int r = Height(root.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    void PostOrderIteratively() {
        PostOrderIteratively(root);
    }

    void PostOrderIteratively(Node root) {
        if (root == null)
            return;

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }

            if (root.right != null) {
                s1.push(root.right);
            }


        }

        while (!s2.isEmpty()) {
            root = s2.pop();
            System.out.println(root.key);
        }


    }

    void PreOrderIteratively() {
        PreOrderIteratively(root);
    }

    void PreOrderIteratively(Node root) {
        if (root == null)
            return;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            System.out.println(root.key);
            if (root.right != null) {
                s.push(root.right);
            }
            if (root.left != null) {
                s.push(root.left);
            }
        }
    }

    //  Node root1;
    void CreateBst(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        Node root1 = CreateBst(arr, start, end);

        PostOrder(root1);
    }

    Node CreateBst(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node newnode = new Node(arr[mid]);
        newnode.left = CreateBst(arr, start, mid - 1);
        newnode.right = CreateBst(arr, mid + 1, end);

        return newnode;
    }

    /*
    void Circumference()
    {
        Node curr = root;

    }
    */
    void LevelOrder() {
        Node curr = root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.peek() != null) {
            Node pp = q.poll();
            System.out.println(pp.key);
            q.add(pp.left);
            q.add(pp.right);

        }

    }

    boolean IsBalanced() {
        return IsBalanced(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean IsBalanced(Node root, int min, int max) {
        if (root == null) return true;
        if (root.key < min && root.key > max)
            return false;
        return IsBalanced(root.left, min, root.key) &&
                IsBalanced(root.right, root.key, max);

    }

    void FindRank() {
       int s =  FindRank(root, 90);
        if(s!=-1)
        System.out.println(s);

    }

   private int FindRank(Node root, int key)
    {


        if(root != null) {
            if (root.key == key) {
                return Sze(root.left);

            } else if (key < root.key) {
                return FindRank(root.left, key);
            }
            else
            return 1 + Sze(root.left) + FindRank(root.right, key);
        }
        else
        return -1;




    }
    int Sze(Node root)
    {
        int  s =  size(root);
        //System.out.println(s);
        return s;
    }

    int size(Node root)
    {
        if(root == null)
            return 0;

        else
       return (size(root.left) + 1 + size(root.right));
    }

    void Inorder()
    {
        Inorder(root);
    }
    void Inorder(Node root)
    {
        if(root == null)    return;
        Stack<Node> s = new Stack<Node>();
        while (true)
        {
            if(root != null)
            {
                s.push(root);
                root = root.left;
            }

            else
            {
                if(s.isEmpty())
                {
                    break;
                }

                root = s.pop();
                System.out.println(root.key);
                root = root.right;
            }
        }

    }

}
public class tree
{

    public static void main(String[] args)
    {

        abc obj = new abc();
        obj.Insert(50);
        obj.Insert(30);
        obj.Insert(20);
        obj.Insert(40);
        obj.Insert(70);
        obj.Insert(60);
        obj.Insert(55);
        obj.Insert(80);

       // obj.PreOrder();

        //obj.Inorder();
        //obj.InsertIteratively(55);


       //obj.DeleteMinimum();
       // obj.DeleteMaximum();
       // obj.PostOrder();
        //System.out.println(obj.Size());
       // obj.Height();
       // obj.Delete();
       // System.out.println("\n\n");

        //obj.PostOrderIteratively();
        //obj.PreOrderIteratively();

       // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
       // obj.CreateBst(arr);
       // obj.Circumference();
       // obj.LevelOrder();
/*
        if(obj.IsBalanced())
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }

*/
       // obj.FindRank();
      //  obj.Inorder();




    }
}



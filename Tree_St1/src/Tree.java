import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by i_amg on 30-09-2016.
 */
class Node
{
    private Node left;
    private Node right;
    private int data;

   public Node(int data)
   {
       this.left = null;
       this.right = null;
       this.data = data;
   }

    public int getData()
    {
        return this.data;
    }
    public void Setdata(int data)
    {
        this.data = data;
    }

    public void Setleft(Node left)
    {
        this.left = left;
    }

    public void Setright(Node right)
    {
        this.right = right;
    }

    public Node Getright()
    {
        return this.right;
    }
    public Node Getleft()
    {
        return this.left;
    }

}

class  B
{
    Node root = null;
    void Insert(int data)
    {
       root = Insert(root, data);
    }

    Node Insert(Node root, int data)
    {
        if(root == null)
        {
            return new Node(data);
        }

        if(data > root.getData())
        {
            root.Setright(Insert(root.Getright(), data));
        }

        if(data < root.getData())
        {
            root.Setleft(Insert(root.Getleft(), data));
        }

        return root;
    }

    void Inorder()
    {
        Inorder(root);
    }
    Node Inorder(Node root)
    {
        if(root == null)
            return root;
        Inorder(root.Getleft());
        System.out.println(root.getData());
        Inorder(root.Getright());
        return root;
    }

    void InorderIteratively()
    {
        InorderIteratively(root);
    }
    void InorderIteratively(Node root)
    {
        Stack<Node> stack = new Stack<Node>();
        while (true) {
            if (root != null)
            {
                stack.push(root);
              root =  root.Getleft();
            }
            else
            {
                if(stack.isEmpty() == true)
                {
                    break;

                }

                root = stack.pop();
                System.out.println(root.getData());
               root  = root.Getright();
            }
        }
    }

    void Preorder()
    {
        Preorder(root);
    }

    void Preorder(Node root)
    {
        if(root == null)
            return;
        System.out.println(root.getData());
        Preorder(root.Getleft());
        Preorder(root.Getright());
    }

    void PreorderIteratively()
    {
        PreorderIteratively(root);
    }

   void PreorderIteratively(Node root)
    {
       Stack<Node>  stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            root = stack.pop();
            System.out.println(root.getData());
            if(root.Getright() != null)
            {
                stack.push(root.Getright());
            }

            if(root.Getleft() != null)
            {
                stack.push(root.Getleft());
            }
        }
    }

    void PostOrder()
    {
        PostOrder(root);
    }

    void PostOrder(Node root)
    {
        if(root == null)
            return;
        PostOrder(root.Getleft());
        PostOrder(root.Getright());
        System.out.println(root.getData());
    }

    void PostOrderIteratively()
    {
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
            if(root.Getleft() != null)
            {
                stack1.push(root.Getleft());
            }

            if(root.Getright() != null)
            {
                stack1.push(root.Getright());
            }

        }

        while (!stack2.isEmpty())
        {
            root = stack2.pop();
            System.out.println(root.getData());
        }

    }

    void GetMinimum()
    {
       Node min= GetMinimum(root);
        System.out.println(min.getData());
    }
    Node GetMinimum(Node root)
    {
        if(root.Getleft() == null)
        {
            return root;
        }

      return GetMinimum(root.Getleft());

    }

    void GetMaximum()
    {
        Node max = GetMaximum(root);
        System.out.println(max.getData());
    }

    Node GetMaximum(Node root)
    {
        if(root.Getright() == null)
        {
            return root;
        }

        return GetMaximum(root.Getright());
    }

    void DeleteMinimum()
    {
        if(root != null)
        {
           root =  DeleteMinimum(root);
        }

    }

    Node DeleteMinimum(Node root)
    {
        if(root.Getleft() == null)
        {
            return root.Getright();
        }

        root.Setleft(DeleteMinimum(root.Getleft()));

        return root;
    }

    void DeleteMaximum()
    {
        if(root.Getright() != null)
        root = DeleteMaximum(root);
    }

    Node DeleteMaximum(Node root)
    {
        if(root.Getright() == null)
        {
            return root.Getleft();
        }

        root.Setright(DeleteMaximum(root.Getright()));
        return  root;
    }

    void Delete(int data)
    {
        root = Delete(root, data);
    }

    Node Delete(Node root, int data)
    {
        if(root == null)
        {
            return root;
        }

        else if(root.getData() < data)
        {
            root.Setright(Delete(root.Getright(), data));
        }

        else if(root.getData() > data)
        {
            root.Setleft(Delete(root.Getleft(), data));
        }

        else
        {
            if(root.Getleft() == null && root.Getright() == null)
            {
                root = null;
            }
            else if(root.Getleft() == null)
            {
                return root.Getright();
            }
            else if(root.Getright() == null)
            {
                return root.Getleft();
            }

            else
            {
                Node temp = GetMinimum(root.Getright());
                root.Setdata(temp.getData());
                root.Setright(Delete(root.Getright(), temp.getData()));
            }
        }

        return root;
    }
/*
    void Sum()
    {
        root = Sum(root, 0);
        Inorder(root);
    }

    void Sum(Node root, int sum)
    {
        if(root == null) return;
        Sum(root.Getright(), sum);

        sum += root.getData();
        root.Setdata(sum);

        Sum(root.Getleft(), sum);
    }
*/

    void DeleteOutSideRange(int a, int b)
    {
       root = DeleteOutSideRange(root, a, b);
    }

    Node DeleteOutSideRange(Node root, int a, int b)
    {
        if(root == null) return root;

       root.Setleft(DeleteOutSideRange(root.Getleft(), a, b));
        root.Setright(DeleteOutSideRange(root.Getright(), a, b));
        if(root.getData() < a || root.getData() > b)// ready to be delete
        {
            if(root.Getleft() == null && root.Getright() == null)
            {
               return null;
            }
            if(root.Getleft() == null)
            {
                return root.Getright();
            }

            if(root.Getright() == null)
            {
                return root.Getleft();
            }

            else
            {
                Node temp = GetMinimum(root.Getright());
                temp.Setdata(temp.getData());
                root.Setright(DeleteMinimum(root.Getright()));
            }

        }

        return root ;
    }


/*
    Node DeleteOutSideRange(Node root, int a, int b)
    {
        if(root == null)
            return null;

        root.Setleft(DeleteOutSideRange(root.Getleft(), a, b));
        root.Setright(DeleteOutSideRange(root.Getright(), a, b));

        if(root.getData() < a)
        {
            return root.Getright();
        }
        if(root.getData() > b)
        {
            return root.Getleft();
        }

        return root;
    }*/

    void ceil(int data)
    {
        System.out.println(ceil(root, data));
    }

    int ceil(Node root, int data)
    {
        if(root == null)
            return Integer.MIN_VALUE;

        if(root.getData() == data)
        {
            return root.getData();
        }
        if(root.getData() < data)
        {
            return ceil(root.Getright(), data);
        }

        int ceil = ceil(root.Getleft(), data);
        if(ceil >= data) return ceil;
        else
            return root.getData();
    }

    void Floor(int data)
    {
        System.out.println(Floor(root, data));
    }

    int Floor(Node root, int data)
    {
        if(root == null)
        {
            return Integer.MAX_VALUE;
        }

        if(root.getData() > data)
        {
            return Floor(root.Getleft(), data);
        }

        int floor = Floor(root.Getright(), data);
        if(floor <= data)
        {
            return floor;
        }
        else
        {
            return root.getData();
        }
    }

    void FindRank(int data)
    {
      int rank  =  FindRank(root, data);
        System.out.println(rank);
    }

    int FindRank(Node root, int data)
    {
        if(root == null)
            return -1;

        if(root.getData() == data)
        {
            return Size(root.Getleft());
        }

        if(root.getData() > data)
        {
            return FindRank(root.Getleft(), data);
        }

        else
        {
            return Size(root.Getleft()) + 1 + FindRank(root.Getright(), data);
        }



    }

    int Size(Node root)
    {
        if(root == null)
            return 0;
        return Size(root.Getleft()) + 1 + Size(root.Getright());
    }

    int Count(int n)
    {
       if(n == 0 || n == 1 )
           return 1;
        else
       {
           int sum = 0, l = 0, r = 0;
           for(int k = 1; k <= n; k++)
           {
               l = Count(k - 1);
               r = Count(n - k);
               sum += l * r;

           }

           return sum;
       }

    }

    void PrintPath()
    {
        PrintPath(root, new int[1500], 0);
    }

    void PrintPath(Node root, int[] arr, int i)
    {
        if(root == null)
            return;
        arr[i++] = root.getData();

        if(root.Getleft() == null && root.Getright() == null)
        {
            Print(arr, i);
            System.out.println("\n");
        }
        else
        {
            PrintPath(root.Getleft(), arr,  i);
            PrintPath(root.Getright(), arr, i);
        }


    }

    void Print(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    void LevelOrder()
    {
        LevelOrder(root);
    }

    void LevelOrder(Node root)
    {
        if(root ==  null) return;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            root = queue.poll();
            System.out.println(root.getData());
            if(root.Getleft() != null)
            {
                queue.add(root.Getleft());
            }

            if(root.Getright() != null)
            {
                queue.add(root.Getright());
            }
        }

    }

    void LevelOrderPrinting()
    {
        LevelOrderPrinting(root);
    }

    void LevelOrderPrinting(Node root)
    {
        if(root == null) return;
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty())
        {
            while (!queue1.isEmpty())
            {
                root = queue1.poll();
                System.out.print(root.getData() + " ");
                if(root.Getleft() != null)
                {
                    queue2.add(root.Getleft());
                }

                if(root.Getright() != null)
                {
                    queue2.add(root.Getright());
                }
            }

            System.out.println("\n");

            while (!queue2.isEmpty())
            {
                root = queue2.poll();
                System.out.print(root.getData() + " ");

                if(root.Getleft() != null)
                {
                    queue1.add(root.Getleft());
                }

                if(root.Getright() != null)
                {
                    queue1.add(root.Getright());
                }
            }

            System.out.println("\n");
        }
    }

    void ReverseLevelOrder()
    {
        ReverseLevelOrder(root);
    }

    void ReverseLevelOrder(Node root)
    {
        Queue<Node> queue = new LinkedList<Node>();
        Stack<Node> stack = new Stack<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            root = queue.poll();
            stack.push(root);
            if(root.Getright() != null)
            {
                queue.add(root.Getright());
            }
            if(root.Getleft() != null)
            {
                queue.add(root.Getleft());
            }

        }

        while (!stack.isEmpty())
        {
            root = stack.pop();
            System.out.println(root.getData());
        }
    }

    void SumLeafe()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        SumLeafe(root, arr);
        int sum  = 0;
        for(int i = 0; i < arr.size(); i++)
        {
            sum += arr.get(i);
        }

        System.out.println(sum);
    }

    void SumLeafe(Node root, ArrayList<Integer> arr)
    {
        if(root == null)
            return;

        if(root.Getleft() == null && root.Getright() == null)
        {
            arr.add(root.getData());
        }

        SumLeafe(root.Getleft(), arr);

        SumLeafe(root.Getright(), arr);


    }

    void IsSebling(int a, int b)
    {
        if(IsSebling(root, a, b))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }

    boolean IsSebling(Node root, int a, int b)
    {
        if(root ==  null)
            return false;

        return ((root.Getleft().getData() == a && root.Getright().getData() == b) || (root.Getright().getData() == a && root.Getleft().getData() == b) || IsSebling(root.Getleft(), a, b) || IsSebling(root.Getright(), a, b));
    }

}
public class Tree
{
    public static void main(String[] args)
    {
        B obj = new B();

        obj.Insert(20);
        obj.Insert(30);
        obj.Insert(15);
        obj.Insert(25);
        obj.Insert(40);
        obj.Insert(10);
        obj.Insert(18);


       // obj.InorderIteratively();
        //obj.Preorder();
       // obj.PreorderIteratively();
       // obj.PostOrder();
        //System.out.println();
        //obj.PostOrderIteratively();
        //obj.GetMinimum();
        //obj.GetMaximum();
       // obj.DeleteMinimum();
       // obj.DeleteMaximum();

        //obj.Delete(25);
        //obj.Inorder();
       // obj.Sum();
       // obj.DeleteOutSideRange(10, 25);

       // System.out.println("\n");
       // obj.Inorder();
       // obj.ceil(22);
        //obj.Floor(22);
       // obj.FindRank(18);
       // int count =  obj.Count(5);
       // System.out.println(count);
       // obj.PrintPath();
       // obj.LevelOrder();

       // obj.LevelOrderPrinting();
       // obj.ReverseLevelOrder();
        obj.SumLeafe();
        obj.IsSebling(15, 30);
    }
}

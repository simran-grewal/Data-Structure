import sun.reflect.generics.tree.Tree;

import java.util.Comparator;

/**
 * Created by i_amg on 14-10-2016.
 */

public class OperatingSystem implements Comparator
{
    TreeNode root = null;
    class Preority
    {
        int avgTime;
        int median;

        public Preority(int a, int  b)
        {
            this.avgTime = a;
            this.median = b;
        }
    }

    class Process
    {
        String Pname;
        int Pid;
        public Process(String name, int id)
        {
            Pname = name;
            Pid = id;
        }
    }

    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        Preority key;
        Process value;
        public TreeNode(Preority key, Process value)
        {
            this.key = key;
            this.value = value;
        }

    }
   public int compare(Object obj1, Object obj2)
    {
        Preority O1 = (Preority)obj1;
        Preority O2 = (Preority)obj2;

        if(O1.avgTime > O2.avgTime)
        {
            return 1;
        }
        else if(O1.avgTime < O2.avgTime)
        {
            return -1;
        }
        else
            return 0;
    }

    void Insert(Preority key, Process value)
    {
       root = Insert(root, key, value);
    }

    TreeNode Insert(TreeNode root, Preority key, Process value)
    {
        if(root == null) return new TreeNode(key, value);

        if(compare(key, root.key) == 1)
        {
            root.right = Insert(root.right, key, value);
        }

        else if(compare(key, root.key) == -1)
        {
            root.left = Insert(root.left, key, value);
        }

        return root;
    }
    public void Print()
    {
        Print(root);

    }
    public void Print(TreeNode root)
    {
        if(root == null)
            return;
        Print(root.left);
        System.out.println(root.value.Pname);
        Print(root.right);
    }
    public static void main(String[] args)
    {
        OperatingSystem obj = new OperatingSystem();

        OperatingSystem.Process p1 = obj.new Process("Process1", 101);
        OperatingSystem.Process p2 = obj.new Process("Process2", 102);
        OperatingSystem.Process p3 = obj.new Process("Process3", 103);
        OperatingSystem.Preority pt1 = obj.new Preority(89, 4);
        OperatingSystem.Preority pt2 = obj.new Preority(7, 9);
        OperatingSystem.Preority pt3 = obj.new Preority(3, 6);



        obj.Insert(pt1, p1);
        obj.Insert(pt2, p2);
        obj.Insert(pt3, p3);

        obj.Print();
    }
}


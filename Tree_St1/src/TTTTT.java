/**
 * Created by i_amg on 03-10-2016.
 */

class TreeNode
{
       public TreeNode left;
       public TreeNode right;
       public int data;
       public TreeNode neighbor;

        public TreeNode(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
            this.neighbor = null;
        }
}

class Tree123
{
    TreeNode root;
    void CreateTree()
    {
        root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.left = n5;
        n2.right = n6;
        n6.left  = n7;
        n6.right = n8;

    }

    void Inorder()
    {
        Inorder(root);
    }

    void Inorder(TreeNode root)
    {
        if(root == null) return;
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);

    }

    void PopulateNeighbor()
    {
        PopulateNeighbor(root);
    }

    void PopulateNeighbor(TreeNode root)
    {
        if(root == null) return;

        if(root.left != null)
        {
            if(root.right != null)
            {
                root.left.neighbor = root.right;
            }
            else
            {
                TreeNode ParentNeighbor = root.neighbor;
                TreeNode Neighbor;

                while (ParentNeighbor != null)
                {
                    if(ParentNeighbor.left != null)
                    {
                        Neighbor = ParentNeighbor.left;
                    }
                    else
                    {
                        Neighbor = ParentNeighbor.right;
                    }

                    if(Neighbor != null)
                    {
                        root.left.neighbor = Neighbor;
                        break;
                    }

                    ParentNeighbor = ParentNeighbor.neighbor;
                }
            }
        }

        if(root.right != null)
        {
            TreeNode ParentNeighbor = root.neighbor;
            TreeNode Neighbor;

            while (ParentNeighbor != null)
            {
                if(ParentNeighbor.left != null)
                {
                    Neighbor  = ParentNeighbor.left;
                }
                else
                {
                    Neighbor = ParentNeighbor.right;
                }

                if(Neighbor != null)
                {
                    root.right.neighbor = Neighbor;
                    break;
                }

                ParentNeighbor = ParentNeighbor.neighbor;
            }
        }
            PopulateNeighbor(root.left);
            PopulateNeighbor(root.right);
    }

    void Print()
    {
        TreeNode currentNode = root;
        while (currentNode != null)
        {
            TreeNode temp = currentNode;
            currentNode = null;

            // print all the nodes in the current level
            while(temp != null)
            {
                // keep checking for the left-most node in the level below the current level
                // that is where traversal for next level is going to start
                if (currentNode == null)
                {
                    currentNode = (temp.left != null) ? temp.left : temp.right;
                }

                System.out.print(temp.data + " ");
                temp = temp.neighbor;
            }
            System.out.print("\n\n");
        }
    }
}

public class TTTTT
{
    public static void main(String[] args)
    {
        System.out.println("Grewal");
        Tree123 obj = new Tree123();
        obj.CreateTree();
        //obj.Inorder();

        obj.PopulateNeighbor();
        obj.Print();
    }

}

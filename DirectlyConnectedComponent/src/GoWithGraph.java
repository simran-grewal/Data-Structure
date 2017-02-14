import java.util.Iterator;
import java.util.Stack;

/**
 * Created by i_amg on 25-10-2016.
 */
class Bag
{
    class Node
    {
        Node next;
        int data;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Node root;
    Node last;
    public void enque(int data)
    {
        if(root == null)
        {
            root = new Node(data);
            last = root;
        }
        else
        {
            last.next = new Node(data);
            last = last.next;
        }
    }


    public Iterator<Integer> iterator()
    {

        Iterator<Integer>  iterator = new Iterator<Integer>() {
            private Node curr = root;
            @Override
            public boolean hasNext() {
                return  curr != null;
            }

            @Override
            public Integer next() {
                int s = curr.data;
                curr = curr.next;
                return s;
            }
        };

        return iterator;
    }

    public int Size()
    {
        int size = 0;
        Node curr = root;
        while(curr != null)
        {
            size++;
            curr = curr.next;
        }

        return size;
    }
}
class Graph
{
    int V;
    int E;
    Bag[] adjList;
    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adjList = new Bag[V];
        for(int i = 0; i < V; i++)
        {
            adjList[i] = new Bag();
        }

    }

    public void addEdge(int v, int w)
    {
        adjList[v].enque(w);
        adjList[w].enque(v);
        E++;
    }

    public int[]  GetList(int v)
    {
        int[] arr = new int[adjList[v].Size()];
        int i = 0;
        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext())
        {
            arr[i++]= iterator.next();

        }

        return arr;
    }

    public void DFS()
    {
        boolean[] Marked = new boolean[V];
        for(int i = 0; i < Marked.length; i++)
        {
            if(!Marked[i])
            {
                DFS(Marked, i);
            }

        }
    }

    public void DFS(boolean[] Marked, int v)
    {
        Marked[v] = true;
        System.out.println(v);
        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext()) {
            int s = iterator.next();
            if (!Marked[s])
            {
                DFS(Marked, s);
            }
        }
    }

    public void IteratorDFS()
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] Marked = new boolean[V];
        int v = 0;
        stack.push(v);
        while(!stack.isEmpty())
        {
            v = stack.pop();
            if(!Marked[v])
                System.out.println(v);
            Marked[v] = true;
            Iterator<Integer> iterator = adjList[v].iterator();
            if(iterator.hasNext())
            {

                stack.push(iterator.next());
            }
        }
    }

    public void ConnectedComponent()
    {
        int id = 0;
        int[] DirectlyComponent = new int[V];
        boolean[] Visited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!Visited[i])
            {
                dfs(Visited,i, id++, DirectlyComponent);
                //id++;
            }


        }


        for(int i = 0; i < DirectlyComponent.length; i++)
        {
            System.out.println(DirectlyComponent[i]);
        }
    }

    public void dfs(boolean[] Marked, int v, int id, int[] DirectlyComponent)
    {
        DirectlyComponent[v] = id;
        Marked[v] = true;
       // System.out.println(v);
        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext())
        {
            int s = iterator.next();
            if (!Marked[s])
            {
                dfs(Marked, s, id, DirectlyComponent);
            }
        }
    }

    public void ShortestPath(int v)
    {
        boolean[] Visited = new boolean[this.V];
    }
}
public class GoWithGraph
{
    public static void main(String[] args)
    {
        Graph G = new Graph(8);
        G.addEdge(0, 1);
        G.addEdge(2, 3);
        G.addEdge(4, 5);
        G.addEdge(6, 7);/*
        G.addEdge(2, 3);
        G.addEdge(4, 6);
        G.addEdge(6, 7);
*/
        G.ConnectedComponent();
        G.ShortestPath(1);


    }
}

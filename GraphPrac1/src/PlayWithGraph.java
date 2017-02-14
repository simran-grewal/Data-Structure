import java.net.Inet4Address;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i_amg on 24-10-2016.
 */
class Bag implements Iterable
{
    class  Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }

    }
    Node root, last;
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

        Iterator<Integer> iterator = new Iterator<Integer>() {
             Node curr = root;
            @Override
            public boolean hasNext() {

                return curr != null;
            }

            @Override
            public Integer next() {

                Node s = curr;
                curr = curr.next;
                return s.data;


            }
        };


        return iterator;
    }


    int Size()
    {
        int size = 0;
        Node curr = root;
        while (curr != null)
        {
            size++;
            curr = curr.next;
        }

        return size;
    }

}
class Graph
{
    int Vertices, Edges;
    Bag[] adjList;
    public Graph(int v)
    {
        adjList = new Bag[v];
        this.Edges = 0;
        this.Vertices = v;

        for(int i = 0; i < v; i++)
        {
            adjList[i] = new Bag();
        }
    }

    public void addEdges(int v, int w)
    {
        adjList[v].enque(w);
        adjList[w].enque(v);

        this.Edges++;
    }

    int[] GetList(int v)
    {
        Iterator<Integer> iterator = adjList[v].iterator();
        int[] arr = new int[adjList[v].Size()];
        int i = 0;
        while (iterator.hasNext())
        {
            arr[i++] = iterator.next();
        }

        return arr;
    }


    void DFS(int v)
    {
        boolean[] Visited = new boolean[Vertices];
        dfs(Visited, v);
    }

    void dfs(boolean[] Visited, int v)
    {
        Visited[v] = true;
        Iterator<Integer> iterator = adjList[v].iterator();
        System.out.println(v);

        while (iterator.hasNext())
        {
            int s = iterator.next();
            if(!Visited[s])
            {
                dfs(Visited, s);
            }
        }
    }

    void BSF(int v)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] Visited = new boolean[v];
        queue.add(v);
        Visited[v] = true;

        while (!queue.isEmpty())
        {
            v = queue.poll();
            System.out.println(v);

            Iterator<Integer> iterator = adjList[v].iterator();
            while (iterator.hasNext())
            {
                int s = iterator.next();

                if(!Visited[s])
                {
                    Visited[s] = true;
                    queue.add(s);
                }
            }
        }

    }
}
public class PlayWithGraph
{
    public static void main(String[] args)
    {
        Graph G = new Graph(7);
        G.addEdges(0, 1);
        G.addEdges(1, 2);
        G.addEdges(2, 3);
        G.addEdges(3, 4);
        G.addEdges(0, 4);
       int[] arr =  G.GetList(3);
        for(int i : arr)
        {
          //  System.out.println(i);
        }

       // G.DFS(3);
        G.BSF(1);
    }
}

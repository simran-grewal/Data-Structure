import java.util.Iterator;

/**
 * Created by i_amg on 26-10-2016.
 */
class Bag implements Iterable<Integer>
{
    class Node
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
    public Bag()
    {
        this.root = null;
        this.last = null;
    }
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

    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private Node curr = root;

            @Override
            public boolean hasNext()
            {
                return curr != null;
            }

            @Override
            public Integer next()
            {
                int data = curr.data;
                curr = curr.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
        return it;
    }

    public int Size()
    {
        Node curr = root;
        int size = 0;
        while(curr!= null)
        {
            size++;
            curr = curr.next;
        }
        return size;
    }


}
class Graph
{
    int E;
    int V;
    Bag[] adjList;
    public Graph(int v)
    {
        adjList = new Bag[v];
        this.V = v;
        for(int i = 0; i < v; i++)
        {
            adjList[i] = new Bag();
        }
    }

    void addEdge(int v, int w)
    {
        adjList[v].enque(w);
        adjList[w].enque(v);
        E += 1;
    }

    int noOfEdges()
    {
        return E;
    }

    public int[] GetList(int v)
    {
        Iterator iterator  =  adjList[v].iterator();
        int arr[] = new int[adjList[v].Size()];
        int i = 0;
        while(iterator.hasNext())
        {
            arr[i++] = (Integer)iterator.next();

        }


        return arr;
    }

    public void dfs(int data)
    {
        boolean[] Visited = new boolean[V];
        dfs(Visited, data);
    }
    void dfs(boolean[] Visited, int data)
    {
        Visited[data] = true;
        System.out.println(data);
        for(int w : adjList[data])
        {
            if(!Visited[w])
            {
                dfs(Visited, w);
            }
        }
    }

/*
    public boolean IsCycle()
    {

    }
*/
}
public class CycleInGraph
{
    public static void main(String[] args)
    {
        Graph obj = new Graph(4);
        obj.addEdge(0, 1);
        obj.addEdge(1, 2);
        obj.addEdge(2, 3);
        obj.addEdge(1, 3);
        obj.dfs(1);
        //obj.IsCycle();

    }
}

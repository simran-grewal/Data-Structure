import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i_amg on 22-12-2016.
 */
class Graph
{
    LinkedList<Integer>[] adjList;
    int V;
    int E;
    public Graph(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];

        for(int i = 0; i < V; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }

        this.E = 0;
    }

    public void addEdge(int v, int w)
    {
        adjList[v].add(w);
        adjList[w].add(v);
        this.E++;
    }

    void dfs()
    {
        boolean[] Visited = new boolean[this.V];
        for(int i = 0; i < this.V; i++)
        {
            if(!Visited[i])
            {
                dfs(0, Visited);
            }
        }
    }

    void dfs(int v, boolean[] Visited)
    {
        Visited[v] = true;
        System.out.println(v);
        for(int w : adjList[v])
        {
            if(!Visited[w])
            {
                dfs(w, Visited);
            }
        }
    }

    void bsf(int v)
    {
        boolean[] Marked = new boolean[this.V];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        Marked[v] = true;
        while(!queue.isEmpty())
        {
            int value = queue.poll();
            System.out.println(value);
            Iterator<Integer> iterator = adjList[value].iterator();
            while(iterator.hasNext())
            {
                int s = iterator.next();
                if(!Marked[s])
                {
                    Marked[s] = true;
                    queue.add(s);
                }
            }
        }
    }
}
public class GraphLinked
{
    public static void main(String[] args)
    {
        Graph G = new Graph(6);
        G.addEdge(4, 5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 3);
       // G.dfs();
        G.bsf(0);

    }

}

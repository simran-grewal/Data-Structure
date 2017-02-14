import java.util.LinkedList;

/**
 * Created by i_amg on 11-11-2016.
 */
class Graph
{
    LinkedList<Integer>[] adjList;
    int V, E;
    public Graph(int V)
    {
        this.V = V;
        adjList = new LinkedList[V];
        for(int i = 0; i < V; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void Insert(int v, int w)
    {
        adjList[v].add(w);
        adjList[w].add(v);
        this.E++;
    }

    public void dfs()
    {
        boolean[] Visited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!Visited[i])
            dfs(Visited, i);
        }


    }

    public void dfs(boolean[] Visited, int i)
    {
        Visited[i] = true;
        System.out.println(i);
        for(int w : adjList[i])
        {
            if(!Visited[w])
            {
                dfs(Visited, w);
            }
        }
    }
}
public class LetsGraph
{
    public static void main(String[] args)
    {
        Graph G = new Graph(4);
        G.Insert(0, 1);
        G.Insert(1, 2);
        G.Insert(2, 3);
        G.Insert(3, 0);

        G.dfs();

    }
}

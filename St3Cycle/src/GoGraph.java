import java.util.LinkedList;

/**
 * Created by i_amg on 23-11-2016.
 */
class Graph
{
    int V;
    int E;
    boolean Cycle = false;
    LinkedList<Integer>[] adjList;
    public Graph(int V)
    {
        this.V = V;
        this.E = 0;
        adjList = new LinkedList[this.V];

        for(int i = 0; i < this.V; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int w, int v)
    {
        adjList[w].add(v);
        adjList[v].add(w);
        this.E++;
    }

    public boolean IsCycle()
    {
        boolean[] Visited = new boolean[this.V];
        for(int i = 0; i < this.V; i++)
        {
            this.Cycle = dfs(Visited , i, -1);
        }


        return this.Cycle;
    }

    public boolean dfs(boolean[] Visited, int i, int p)
    {
        Visited[i] = true;
        for(int w : adjList[i])
        {
            if(!Visited[w])
            {
                dfs(Visited, w, i);
            }

            else
                if(p > -1 && w != p)
                {
                    this.Cycle = true;
                }
        }

        return this.Cycle;
    }

    boolean IsBiper = true;
    public boolean IsBipertite()
    {
        boolean[] Visited = new boolean[this.V];
        char[] Color = new char[this.V];
        Color[0] = 'R';
        DFS(Visited, Color, 0);
        for(int i = 0; i < this.V; i++)
        {
            if(!Visited[i])
            {
                IsBiper = false;
            }
        }

        return  IsBiper;

    }

    public void DFS(boolean[] Visited, char[] Color, int i)
    {
        Visited[i] = true;
        for(int w : adjList[i])
        {
            if(!Visited[w])
            {
                if(Color[i] == 'R')
                {
                    Color[w] = 'B';
                }

                else
                {
                    Color[w] = 'R';
                }

                DFS(Visited, Color, w);
            }

            else
            {
                if(Color[w] == Color[i])
                {
                    IsBiper = false;
                }
            }
        }


    }
}
public class GoGraph
{
    public static void main(String[] args)
    {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
       // g.addEdge(2, 4);
        System.out.println(g.IsBipertite());

    }
}

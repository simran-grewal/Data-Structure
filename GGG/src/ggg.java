import sun.plugin2.applet.context.NoopExecutionContext;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i_amg on 05-11-2016.
 */
class Graph
{
    LinkedList<Integer>[] adjList;
    int  V;
    int E;
    public Graph(int v)
    {
        this.V = v;

        adjList = new LinkedList[v];

        for(int i = 0; i < v; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }

        this.E = 0;

    }

    public void addEdge(int v, int w)
    {
        adjList[v].add(w);
        adjList[w].add(v);
        E++;
    }

    int[] Get_List(int v)
    {
        int i = 0;
        int[] arr = new int[adjList[v].size()];
        Iterator<Integer> iterator = adjList[v].iterator();
        while (iterator.hasNext())
        {
            arr[i] = iterator.next();
            i++;
        }

        return arr;
    }

    void DFS(int v)
    {
        boolean[] Visited = new boolean[this.V];
        dfs(Visited , v);
    }


    void dfs(boolean[] Visited, int v)
    {
        Visited[v] = true;
        System.out.println(v);
        for(int w : adjList[v])
        {
            if(!Visited[w])
            {
                dfs(Visited, w);
            }
        }
    }

    void BFS(int v)
    {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);

        boolean[] Visited =  new boolean[this.V];
        Visited[v] = true;

        while (!queue.isEmpty())
        {
            int s = queue.poll();
            System.out.println(s);
            for (int w : adjList[s])
            {
                if(!Visited[w])
                {
                    Visited[w] = true;
                    queue.add(w);
                }
            }
        }
    }

}
public class ggg
{
    public static void main(String[] args)
    {
        Graph G = new Graph(6);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(4, 5);
        G.addEdge(2, 3);
        G.addEdge(3, 1);
        G.addEdge(3, 0);

        int[] arr  = G.Get_List(3);

        for(int i = 0; i < arr.length; i++)
        {
           // System.out.println(arr[i]);
        }

        //G.DFS(3);
        G.BFS(2);
    }
}

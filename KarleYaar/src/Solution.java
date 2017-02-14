import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by i_amg on 22-12-2016.
 */
class Grap
{
    int V;
    boolean IsTree = true;
    LinkedList<Integer>[] adjList;
    public Grap(int v)
    {
        this.V = v;
        adjList = new LinkedList[this.V];
        for(int i = 0; i < v; i++)
        {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int w, int v)
    {
        adjList[v].add(w);
        adjList[w].add(v);

    }

    boolean IsTree()
    {

        boolean[] Marked = new boolean[this.V];
        dfs(0, Marked, -1);
        for(int i = 0; i < Marked.length; i++)
        {
            if(Marked[i] == false)
                IsTree = false;
        }
        return IsTree;
    }

    void dfs(int v, boolean[] Marked, int p)
    {
        for(int w : adjList[v])
        {
            if(!Marked[w])
            {
                Marked[w] = true;
                dfs(w, Marked, v);
            }
            else if(w != p && p > 0)
            {
                IsTree = false;
            }
        }
    }
}
public class Solution
{
    public static void main(String[] args)
    {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for(int i = 0; i < t; i++)
        {

            int V = sc.nextInt();
            Grap G = new Grap(V);
            int E = sc.nextInt();
            for(int j = 0; j < E; j++)
            {
                G.addEdge(sc.nextInt(), sc.nextInt());

            }

            System.out.println(G.IsTree());
        }
    }
}

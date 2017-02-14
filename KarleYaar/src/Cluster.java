/**
 * Created by i_amg on 23-12-2016.
 */
class NoOfClustor
{
    int[] ofset = {-1, 0, 1};
    public boolean Exist(int[][] Matrix, boolean[][] Visited, )
    public void ApplyLogic(int[][] Matrix, boolean[][] Visited, int i,  int j)
    {
        if(Visited[i][j])
        {
            return;
        }

        Visited[i][j] = true;
        int Xofset, Yofset;
        for(int x = 0; x < ofset.length; x++)
        {
            Xofset = ofset[x];

            for(int y = 0; y < ofset.length; y++)
            {
                Yofset = ofset[y];

                if(Xofset == 0 && Yofset == 0)
                {
                    continue;
                }

                if(Exist(Matrix, i + Xofset, j + Yofset))
                {
                    ApplyLogic(Matrix,Visited,  i + Xofset, j + Yofset);
                }
            }


        }
    }
    public void FindNoOfClustor(int[][] Matrix)
    {
        boolean[][] Visited = new boolean[Matrix.length][Matrix[0].length];
        int count = 0;
        for(int i = 0; i < Matrix.length; i++)
        {
            for(int j = 0; j < Matrix[0].length; j++)
            {
                if(!Visited[i][j] && Matrix[i][j] ==  1)
                {
                    count++;
                    ApplyLogic(Matrix,Visited, i, j);
                }
            }
        }
    }
}
public class Cluster
{
    public static void main(String[] args)
    {
        int[][] Matrix = {
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1},

        };


        NoOfClustor obj = new NoOfClustor();
        obj.FindNoOfClustor(Matrix);
    }
}
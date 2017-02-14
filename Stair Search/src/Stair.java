/**
 * Created by i_amg on 06-09-2016.
 */
public class Stair
{
    public int Search(int[][] arr, int l, int e)
    {
        int r = 0;
        int c = l - 1;
        if(e > arr[l - 1][l -1] || e < arr[0][0]) return 0;
        while (r <= l - 1 && c >= 0)
        {
            if(arr[r][c] < e)
                r++;
            else if(arr[r][c] > e)
                c--;
            else
                return  1;
        }

        return 0;
    }
    public static void main(String[] args)
    {
        int[][] arr = {{2, 6, 7, 11},
                        {3, 8, 10, 12},
                        {4, 9, 11, 13},
                        {5, 15, 16, 18}

                        };
        Stair obj = new Stair();
        System.out.println(obj.Search(arr, arr.length, 14));

    }
}

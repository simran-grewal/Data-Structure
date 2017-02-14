import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by i_amg on 07-09-2016.
 */
public class Duplicate
{
    public int RemoveDuplicates(int[] arr)
    {
        int n = arr.length;
        int prev = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] != arr[prev])
            {
                arr[++prev] = arr[i];
            }
        }

        n = prev + 1;

        return n;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = s.nextInt();
        }
        Duplicate obj = new Duplicate();

       int n = obj.RemoveDuplicates(arr);

        for(int i = 0; i < n; i++)
        {
            System.out.println(arr[i]);
        }
    }
}

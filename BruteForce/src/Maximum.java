import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by i_amg on 09-10-2016.
 */
public class Maximum {
    public static void Print(int[] arr, int k)
    {
        for(int i = 0; i <= arr.length - k; i++)
        {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < k + i; j++)
            {
                max = Math.max(arr[j], max);
            }

            System.out.print(max + " ");
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {9, 6, 11, 8, 10, 5, 14, 13, 93, 14};
        Print(arr, 4);

    }
}

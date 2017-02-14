/**
 * Created by i_amg on 09-09-2016.
 */
import java.lang.Math.*;
public class Count
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2, 8, 5, 7, 6, 8, 5};
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[Math.abs(arr[i])] <0)
            {
                System.out.println(Math.abs(arr[i]));
            }

            else
            {
                arr[Math.abs(arr[i])] *= -1;
            }
        }
    }
}

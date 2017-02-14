/**
 * Created by i_amg on 27-09-2016.
 */
// for protected in abstract class we can grow upto public
public class selsort extends sort
{
  protected void ssort(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                   swap(arr, i, j);
                }
            }
        }
    }
}

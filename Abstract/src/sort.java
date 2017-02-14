/**
 * Created by i_amg on 27-09-2016.
 */
public abstract class sort
{

    protected void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    protected void print(int[] arr)
    {
        for(int i : arr)
        {
            System.out.println(i);
        }

    }

    protected abstract void ssort(int[] arr);
}

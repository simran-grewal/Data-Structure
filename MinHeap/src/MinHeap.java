/**
 * Created by i_amg on 16-10-2016.
 */
class Heap
{
    int[] arr = {3, 5, 1, 2, 7, 8, 9, 12, 14, 13};
    int N = arr.length;
    int[] arr1 = new int[N + 1];

    void Convert()
    {
        arr1[0] = 0;
        int k = 1;
        for(int i = 0; i < arr.length; i++)
        {
            arr1[k++] = arr[i];
        }
        arr = arr1;
        N = arr.length;
        for(int i : arr)
        {
            System.out.println(i);
        }
    }

    void Sort()
    {
        for(int i = N/2; )
    }

}
public class MinHeap
{

    public static void main(String[] args)
    {
        Heap obj = new Heap();
        obj.Convert();
        obj.Sort();
    }
}

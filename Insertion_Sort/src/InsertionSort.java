/**
 * Created by i_amg on 10-09-2016.
 */
public class InsertionSort
{
   static void Sort(int[] arr, int n)
    {
        int i;
        for(i = 1; i < n; i++)
        {
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && key < arr[j])
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 7, 1, 5, 8, 3};
        Sort(arr, arr.length);
        for(int i : arr)
        {
            System.out.println(i);
        }
    }
}

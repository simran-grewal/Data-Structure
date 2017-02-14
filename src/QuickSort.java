/**
 * Created by i_amg on 06-09-2016.
 */
public class QuickSort
{
    void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int[] arr, int l, int r)
    {
        int pivot = arr[r];
        int i = l - 1;
        int j;
        for(j = l ; j < r; j++)
        {
            if(arr[j] <= pivot)
            {
                i++;
                this.swap(arr, i, j);
            }
        }

        this.swap(arr, i + 1, r);

        return i + 1;
    }
    public void Quick_Sort(int[] arr, int l, int r)
    {
        if(l < r)
        {
            int pi = this.partition(arr, l, r);
            Quick_Sort(arr, l, pi - 1);
            Quick_Sort(arr, pi + 1, r);
        }

    }
    public static void main(String[] args)
    {
        int[] arr = {5, 7, 1, 2, 3};
        int n = arr.length;
        QuickSort obj = new QuickSort();
        obj.Quick_Sort(arr, 0, n - 1);

        for(int p : arr)
        {
            System.out.println(p);
        }
    }
}

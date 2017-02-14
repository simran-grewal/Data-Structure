/**
 * Created by i_amg on 08-09-2016.
 */
public class QuickSort
{
    public void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void Sort(int[] arr, int l, int r)
    {
        if(l >= r)
            return;
        int last = l;
        int i ;
        for(i = l + 1; i <= r; i++)
        {
            if(arr[i] < arr[l])
            {
                swap(arr, i, ++last);
            }
        }

        swap(arr,l,last);
        Sort(arr, l, last - 1);
        Sort(arr, last + 1, r);

    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] arr = {6, 2, 4, 1, 9, 5};
        int n = arr.length;
        obj.Sort(arr, 0, n - 1);

        for (int p : arr)
        {
            System.out.printf(" "+p);
        }
    }
}

/**
 * Created by i_amg on 07-09-2016.
 */
public class Qsort
{
    void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp  ;
    }
    void Sort(int[] arr, int l, int r)
    {
        if(l >= r) return;
        int last = l;
        int i;
        for(i = l + 1; i <= r; i++)
        {
            if(arr[i] < arr[l])
            {
                swap(arr, i, ++last);
            }
        }

        swap(arr, l, last);
        Sort(arr, l, last - 1);
        Sort(arr, last + 1, r);
    }
    public static void main(String[] args) {


        int[] arr = {7, 2, 4, 1, 8, 3};
        Qsort obj = new Qsort();
        obj.Sort(arr, 0, arr.length - 1);
        for(int i : arr)
        {
            System.out.println(i);
        }
    }

}

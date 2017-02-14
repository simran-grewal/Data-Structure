/**
 * Created by i_amg on 08-09-2016.
 */
public class MergeSort
{
    void Merge(int[] arr, int l, int mid, int  r)
    {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int i,j;
        for(i = 0; i < n1; i++)
        {
            arr1[i] = arr[i  + l];
        }

        for(j = 0; j < n2; j++)
        {
            arr2[j] = arr[mid + 1 + j];
        }

        int k = l;j = 0; i = 0;

        while(i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                arr[k] = arr1[i++];
            }
            else
            {
                arr[k] = arr2[j++];
            }

            k++;
        }

        while(i < n1)
        {
            arr[k++] = arr1[i++];
        }
        while(j < n2)
        {
            arr[k++] = arr2[j++];
        }
    }
    void Sort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int mid = (low + high)/2;
            Sort(arr, low, mid);
            Sort(arr, mid + 1, high);
            Merge(arr, low, mid, high);
        }

    }
    public static void main(String[] args)
    {
        int[] arr = {6, 2, 5, 1, 9, 3};
        MergeSort obj = new MergeSort();
       obj.Sort(arr, 0, arr.length - 1);

        for(int p : arr)
        {
            System.out.println(" "+ p);
        }
    }
}

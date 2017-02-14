/**
 * Created by i_amg on 06-09-2016.
 */
public class Msort
{
    void Merge(int[] arr, int  l,int mid, int r)
    {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i = 0; i < n1; i++)
        {
            arr1[i] = arr[l + i];
        }

        for(int j = 0; j < n2; j++)
        {
            arr2[j] =  arr[mid + 1 + j];
        }

        int k = l, i = 0, j = 0;
        while (i < n1 && j < n2)
        {
            if(arr1[i] < arr2[j])
            {
                arr[k] = arr1[i];
                i++;
            }
            else
            {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k++] = arr1[i++];
        }
        while (j < n2)
        {
            arr[k++] = arr2[j++];
        }


    }
    public void MergeSort(int[] arr, int l, int h)
    {
        if(l < h)
        {
            int mid = (l + h)/2;
            MergeSort(arr, l, mid);
            MergeSort(arr, mid + 1, h);
           this.Merge(arr, l, mid, h);
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {5, 1, 3, 9, 2, 6, 4};
        int n = arr.length;
        Msort obj = new Msort();
        obj.MergeSort(arr, 0, n - 1);

        for(int p : arr)
        {
            System.out.println(p);
        }
    }
}

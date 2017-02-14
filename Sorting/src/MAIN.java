import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.ArrayList;

/**
 * Created by i_amg on 03-10-2016.
 */
public class MAIN
{
    void BubbleSort()
    {
        int[] arr = {7, 4, 6, 2, 3, 1};
        BubbleSort(arr, arr.length);

        for(int i : arr)
        {
            System.out.println(i);
        }
    }

    void BubbleSort(int[] arr, int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if(arr[j] > arr[j + 1])
                {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    void InsertionSort()
    {
        int[] arr = {7, 4, 6, 2, 3, 1};
        InsertionSort(arr, arr.length);

        for(int i : arr)
        {
            System.out.println(i);
        }

    }

    void InsertionSort(int[] arr, int n)
    {
        for(int i = 1; i < n; i++)
        {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && key < arr[j] )
            {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    void swap(int[] arr,int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        MAIN obj = new MAIN();
        //obj.BubbleSort();
       // obj.InsertionSort();


    }
}

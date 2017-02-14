import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.awt.*;

/**
 * Created by i_amg on 06-10-2016.
 */
class Heap
{
    int[] arr = new int[50];
    int N = 0;
    public void Insert(int value)
    {
        arr[++N] = value;
        Swim(N);
    }

    private void Swim(int i)
    {
        if(i <= 1) return;
        if(arr[i] > arr[i/2])
        {
            swap(i, i/2);
        }

        Swim(i/2);
    }

    private void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void print()
    {
        for(int i = 1; i <=N; i++)
        {
            System.out.println(arr[i]);
        }
    }
}
public class HeapSort
{
    public static void main(String[] args)
    {
        Heap obj = new Heap();
        obj.Insert(9);
        obj.Insert(5);
        obj.Insert(6);
        obj.Insert(2);
        obj.Insert(7);
        obj.Insert(1);
        //obj.print();
    }
}

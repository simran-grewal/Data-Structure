/**
 * Created by i_amg on 11-10-2016.
 */
class GoWithHeap
{
    int[] arr = new int[50];
    int N = 0;
    int M = 0;
    void Insert(int value)
    {
        arr[++N] = value;
        Swim(N);
    }
    public int GetMax()
    {
        if(N == 0)
        {
            System.out.println("Heap Is Empty ");
            return -1;
        }

        int temp = arr[1];
        swap(1, N);
        N--;
        Sink(1);

        return temp;
    }
    private void Sink(int i)
    {
        int max = i; int  L = 2 * i; int R = L + 1;
        if(L <= N)
        {
            if(arr[L] > arr[max])
            {
                max = L;
            }
        }

        if(R <= N)
        {
            if(arr[R] > arr[max])
            {
                max = R;
            }
        }

        if(max != i)
        {
            swap(max, i);
            Sink(max);
        }
    }
    public void  Sort(int[] arr, int N)
    {
            M = N;
        for(int i = N/2; i >= 1; i--)
        {
            Sink(arr, i, N);
        }

        while(M > 1)
        {
           GetMax(arr);

        }
        //GetMax(arr, N);

        Print(arr, N);
    }

    private void   GetMax(int[] arr)
    {
        swap(1, M, arr);
        M--;
        Sink(arr,1, M);

    }
    private void Sink(int[] arr, int i, int N)
    {
        int max = i; int L = 2 * i; int R = L + 1;
        if(L <= N)
        {
            if(arr[L] > arr[max])
            {
                 max = L;
            }
        }

        if(R <= N)
        {
            if(arr[R] > arr[max])
            {
                max = R;
            }
        }

        if(max != i)
        {
            swap(max, i);
            Sink(arr, max, N);
        }
    }
    private void Swim(int i)
    {
        if(i <= 1) return;
        if(arr[i/2] <  arr[i])
        {
            swap(i/2, i);
            Swim(i/2);
        }
    }
    private void swap(int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    private void swap(int a, int b, int[] arr)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void Print()
    {
        for(int i = 1; i <= N; i++)
        {
            System.out.println(arr[i]);
        }
    }
    private void Print(int[] arr, int N)
    {
        for(int i = 1; i <= N; i++)
        {
            System.out.println(arr[i]);
        }
    }

}
public class Heap
{
    public static void main(String[] args)
    {GoWithHeap obj = new GoWithHeap();
     /*   obj.Insert(11);
        obj.Insert(6);
        obj.Insert(10);
        obj.Insert(4);
        obj.Insert(3);
        obj.Insert(7);
        obj.GetMax(); // will Delete the Maximum value of heap
        obj.Print();
*/
        int[] arr = {0 ,11, 6, 10, 4, 3, 7};
        obj.Sort(arr, arr.length - 1);
    }
}

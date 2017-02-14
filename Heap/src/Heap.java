/**
 * Created by i_amg on 07-10-2016.
 */
class HeapWoo {
    int[] arr = new int[30];
    int N = 0;

    public void Insert(int i) {
        arr[++N] = i;
        Swim(N);
    }

    private void Swim(int i) {
        if (i <= 1)
            return;

        if (arr[i] > arr[i / 2]) {
            swap(i, i / 2);
            Swim(i / 2);
        }
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void print() {
        for (int i = 1; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }

    public void DeleteMaximum() {
        int m = arr[1];
        swap(1, N);
        N--;
        Sink(1);
        System.out.println("Removed= " + m);
    }

    private void Sink(int i)
    {
        int max = i, l = 2 * i, r = (2 * i )+ 1;
        if(l <= N && arr[l] > arr[max])
        {
            max  = l;
        }

        if(r <= N &&  arr[r] > arr[max])
        {
            max = r;
        }

        if(max != i)
        {
            swap(max, i);
            Sink(max);
        }
    }

    void Sort()
    {
        for(int i = N/2; i >= 1; i--)
        {
            Sink(i);
        }

        while (N > 1)
        {
            DeleteMaximum();
        }

        for (int i : arr)
        {
            System.out.println(i);
        }
    }

}
public class Heap
{
    public static void main(String[] args)
    {
        HeapWoo obj = new HeapWoo();
        obj.Insert(5);
        obj.Insert(4);
        obj.Insert(3);
        obj.Insert(2);
        obj.Insert(1);
        obj.Insert(7);
        obj.print();
        obj.DeleteMaximum();
        obj.print();
        obj.Sort();
    }
}

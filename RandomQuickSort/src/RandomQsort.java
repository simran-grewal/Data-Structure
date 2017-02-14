import java.util.Random;

/**
 * Created by i_amg on 09-09-2016.
 */
public class RandomQsort
{
    void Findpivot(int[] arr,int l, int r)
    {
        Random obj = new Random();

        long piv =  (obj.nextInt() % (r - l + 1));
        System.out.println(piv);
        //return piv + l;

    }
    void QuickSort(int[] arr, int l,int r)
    {
        Findpivot(arr, l, r);
        //System.out.println(pivot);
    }
    public static void main(String[] args)
    {
        RandomQsort obj = new RandomQsort();
        int[] arr = {6, 3, 4, 1, 2, 8, 9, 5};
        obj.QuickSort(arr, 0, arr.length - 1);
    }
}

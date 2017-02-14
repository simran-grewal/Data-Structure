/**
 * Created by i_amg on 08-09-2016.
 */
public class ShiftedArray
{
    boolean Search(int[] arr, int l, int r, int e)
    {
        if(l <= r)
        {
            int mid = (l + r)/2;
            if(arr[mid] == e)
            {
                return true;
            }

            if(arr[l] <= arr[mid])
            {
                if(e >= arr[l] && e <= arr[mid])
                {
                    return Search(arr, l, mid - 1, e);
                }
                else
                {
                    return Search(arr, mid + 1, r, e);
                }
            }
            else
            {
                if(e >= arr[mid] && e <= arr[r])
                {
                    return Search(arr, mid + 1, r, e);
                }
                else
                {
                    return Search(arr, l, mid - 1, e);
                }
            }
        }

        return false;
    }
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 1, 2, 3};
        ShiftedArray obj = new ShiftedArray();
        System.out.println(obj.Search(arr, 0, arr.length - 1, 4));
    }
}

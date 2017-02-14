import java.util.HashSet;
import java.util.Set;

/**
 * Created by i_amg on 09-10-2016.
 */
public class Consecutive
{
    public static void Consecutive(int[] arr)
    {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i : arr)
        {
            hashSet.add(i);
        }

        int max = 0;

        for(int i : hashSet)
        {
            if(hashSet.contains(i - 1)) continue;
            int length = 0;
            while (hashSet.contains(i++)) length++;
            max = Math.max(length, max);
        }


        System.out.println(max);
    }
    public static void main(String[] args)
    {
        int[] arr = {4, 2, 1,6, 5};

        Consecutive(arr);
    }
}

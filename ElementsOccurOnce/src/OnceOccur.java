/**
 * Created by i_amg on 07-10-2016.
 */
class Once
{
    public int Find(int[] arr, int N)
    {
        int[] countSetBits = new int[32];
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < 32; j++)
            {
                int kthSetBit = 1 << j;
                if(((kthSetBit) & arr[i]) == kthSetBit)
                {
                    countSetBits[j]++;
                }
            }
        }
        int occur = 0;

        for(int i = 0; i < 32; i++)
        {
            countSetBits[i] %= N;

            if(countSetBits[i] == 1)
            {
                occur = occur| (1 << i);
            }
        }

        return occur;
    }
}
public class OnceOccur
{
    public static void main(String[] args)
    {
        int arr[] = { 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 };

        Once obj = new Once();
       int result = obj.Find(arr, 3);
        System.out.println("Result = " + result);
    }
}

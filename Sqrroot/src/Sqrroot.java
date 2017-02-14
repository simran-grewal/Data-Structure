/**
 * Created by i_amg on 08-09-2016.
 */
public class Sqrroot
{
    int FindRoot(int n, int low, int high) {
        if (high <= low) {
            if (low == 0) {
                return 0;
            } else {
                if (high * high > n)
                    return high - 1;
                else
                    return high;
            }
        }

        int mid = (low + high) / 2;
        if (mid * mid == n)
            return mid;
        if (mid * mid < n)
        {
           return FindRoot(n, mid + 1, high);
        }
        else
        {
          return   FindRoot(n, low, mid - 1);
        }

    }
    public static void main(String[] args)
    {
        Sqrroot obj = new Sqrroot();
        System.out.println(obj.FindRoot(16, 0, 16));
    }
}

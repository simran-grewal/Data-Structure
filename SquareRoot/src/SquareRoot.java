/**
 * Created by i_amg on 08-09-2016.
 */
public class SquareRoot
{
    int SquareRoot(int n, int low, int high)
    {

        if(low  >= high)
        {
            if(low == 0)
                return 0;
            if(high * high > n)
            {
                return high - 1;
            }
            else
            {
                return high;
            }
        }

        int mid = (low + high)/2;
        if(mid * mid  == n)
        {
            return  mid;
        }
        if(mid * mid < n)
        {
            return SquareRoot(n, mid + 1, high);
        }
        else
        {
            return SquareRoot(n,low, mid - 1 );
        }

    }
    public static void main(String[] args) {


        int n = 64;
        SquareRoot obj = new SquareRoot();
        System.out.println("Square root of number is = "+obj.SquareRoot(n, 1, n));


    }
}

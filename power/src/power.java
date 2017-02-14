/**
 * Created by i_amg on 08-09-2016.
 */
public class power
{
    int power1(int x, int n, int d)
    {
        if(n == 0) return 1;
       int ans = power1(x, n/2, d)%d;
        if((n %2) != 0) return ((ans * ans)%d*x)%d;
        else
            return (ans * ans)%d;


    }
    public static void main(String[] args)
    {
        power obj = new power();
        int x =-2;
        int n = 5;
        int d = 6;
        int res = obj.power1(x, n, d);
        if(res < 0)
            System.out.println((res + d)%d);
        else
            System.out.println(res);
    }
}

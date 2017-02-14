/**
 * Created by i_amg on 07-09-2016.
 */
public class Extract
{

    void print(long n)
    {
        int i;
        int c = 0;
        for(i = 1 << 30; i > 0; i >>= 1)
        {
            if((n & i) != 0) System.out.print("1");
            else
                System.out.print("0");

        }

    }
    public static void main(String[] args) {
       int n = 5;
        Extract obj = new Extract();
       obj.print(n);

        int p = n & 0XAAAAAAAA;
        int q = n & 0X55555555;
        n = p >> 1 | q << 1;
        System.out.println("\n");
        obj.print(n);
    }
}

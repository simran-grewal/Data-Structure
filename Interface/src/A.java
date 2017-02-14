import java.util.Iterator;

/**
 * Created by i_amg on 22-10-2016.
 */
interface Myfunction
{
    Myfunc value();
}

interface Myfunc
{
    int GetData();
}

class C implements Myfunction
{
   public Myfunc GetData()
    {
        int v = 6;
        System.out.println("Simran grewal");
        final Myfunc ob = new Myfunc() {
            @Override
            public int GetData() {
                return 1;
            }
        }

    }
}
public class A
{
    public static void main(String[] args) {
        B obj = new B();
        obj.GetData();
    }
}

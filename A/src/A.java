/**
 * Created by i_amg on 13-09-2016.
 */
public class A
{
    int x;
    A()
    {
        x = 5;
    }
    public static void main(String[] args) {
        final A a = new A();
        a.x = 7;
    }
}

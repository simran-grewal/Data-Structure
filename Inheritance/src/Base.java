/**
 * Created by i_amg on 12-10-2016.
 */
abstract class A
{
    protected void print()
    {
        System.out.println("GREWAL");
    }

   abstract int Sum(int a, int b);
}

class B extends A
{
    int Sum(int a, int b)
    {
       return a  + b;
    }
}
public class Base
{
    public static void main(String[] args) {
        B obj = new B();
        obj.print();
        System.out.println(obj.Sum(4, 5));
    }
}

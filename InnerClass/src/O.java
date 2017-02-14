/**
 * Created by i_amg on 13-10-2016.
 */
class A
{
   public class Inner
    {
        void Print()
        {
            System.out.println("Grewal");
        }
    }

    void abc()
    {
        System.out.println("Sirman");
    }
}
public class O
{
    public static void main(String[] args) {
        A obj = new A();
        obj.abc();
        A s = new A.Inner();
    }
}

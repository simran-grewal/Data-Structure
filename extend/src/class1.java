/**
 * Created by i_amg on 23-09-2016.
 */

class abc
{
    void s(){System.out.println("fgdf");}
}
public class class1 extends abc
{
    void Set_data()
    {

    }
    void Get_data()
    {
        System.out.println("my name is simran");
        Set_data();
    }
    public static void main(String[] args)
    {
        class1 obj = new class1();
        obj.Get_data();
        obj.s();
    }
}

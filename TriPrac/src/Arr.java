import java.util.ArrayList;

/**
 * Created by i_amg on 11-10-2016.
 */
public class Arr
{
    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("dog");
        arrayList.add("fog");
        arrayList.add("zebra");
        for(int i = 0; i < arrayList.size(); i++)
        {
            String str = arrayList.get(i);
            System.out.println(str);
        }

        //arrayList.clear();
        for(int i = 0; i < arrayList.size(); i++)
        {
            String str = arrayList.get(i);
            System.out.println(str);
            //System.out.println("1");
        }
    }
}

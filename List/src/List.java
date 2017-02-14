import java.util.ArrayList;
import java.util.*;
/**
 * Created by i_amg on 09-10-2016.
 */
public class List
{
    public static void function(int n)
    {
        //System.out.println(n);
        if(n == 0)
            return;

        function(n -1);
        System.out.println(n);

    }
    public static void main(String[] args)
    {
        /*
        ArrayList<String> str = new ArrayList<String>();
        str.add("simran");
        str.add("harman");
        str.add("Grewal");
        str.add("Manjit");
        str.add(2, "GGGG");

        str.remove(2);
        //str.removeAll(str);
        //System.out.println(str);

        ArrayList<String> str1 = new ArrayList<String>(str.subList(0, 3));
       // System.out.println(str1);
        java.util.List<String> obj = str.subList(0, 2);
        System.out.println(obj);*/
        /*
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Simran");
        hashMap.put(2, "harman");
        hashMap.put(3, "Grewal");
        hashMap.put(4, "manjit");
        */
       /* Iterator<Map.Entry<Integer, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> res = iterator.next();
            System.out.printf("Key = "+ res.getKey()+" value ="+res.getValue());
        }*/
        /*
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, String> res = (Map.Entry)iterator.next();
            //Map.Entry res = (Map.Entry)iterator.next();
            System.out.println(res.getValue());
        }

        for(Map.Entry entry : hashMap.entrySet())
        {
            System.out.println(entry.getValue());
        }*/
        /*
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<String, ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        hashMap.put("simran", arr);
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr.add(3);
        hashMap.put("simran", arr);
        arr1.add(54);
        hashMap.put("harman", arr1);*/
        /*
        Iterator<ArrayList<Integer>> itr = hashMap.values().iterator();
        while(itr.hasNext())
        {
            ArrayList<Integer> arrayList = itr.next();
            for(int i : arrayList)
            {
                System.out.print(i + " ");
            }
            System.out.println("\n");
        }  */
        /*
        Iterator<Map.Entry<String, ArrayList<Integer>>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, ArrayList<Integer>> map = iterator.next();
            System.out.println(map.getValue());
        }
        */

        function(5);
    }
}

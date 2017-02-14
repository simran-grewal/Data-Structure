import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by i_amg on 09-10-2016.
 */
public class Hash
{
    public static void main(String[] args)
    {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(6);
        hashSet.add(6);
        Iterator<Integer> itr = hashSet.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * Created by i_amg on 07-03-2017.
 */
public class binary
{

    public static void main(String[] args) {
        String s1 = "simran grewal";
        String s2 = "simran grewal";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> h2 = new HashMap<Integer, Integer>();

        if(ch1.length == ch2.length)
        {
            for(int i = 0; i < ch1.length; i++)
            {
                int c1 = (int)ch1[i];
                int c2 = (int)ch2[i];
                if(!h1.containsKey(c1))
                {
                    h1.put(c1, 1);
                }

                else
                {
                    int temp = h1.get(c1);
                    h1.put(c1, ++temp);
                }



                if(!h2.containsKey(c2))
                {
                    h2.put(c2, 1);
                }
                else
                {
                    int temp = h2.get(c2);
                    h2.put(c2, ++temp);
                }
            }


            boolean ana = true;
            for(Integer key : h1.keySet())
            {

                if(h2.containsKey(key))
                {
                    if (h1.get(key) != h2.get(key))
                    {
                        System.out.println("not anagram");
                        ana = false;
                        break;
                    }

                }

                else
                {
                    System.out.println("NOT anagram");
                    ana = false;
                    break;
                }


            }

            if(ana == true)
                System.out.println("Yo Givin String iS anagram");


        }

        else
        {
            System.out.println("not anagram");
        }

    }
}

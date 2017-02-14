import java.util.Arrays;

/**
 * Created by i_amg on 11-10-2016.
 */
public class Base
{
    public static void main(String[] args)
    {
        String str = "my name is simran";
       // System.out.println(str);
        String[] s = str.split(" ");
        //Arrays.sort(s);

       // System.out.println(temp);
        for(int i = 0; i < s.length; i++)
        {
            for(int j = i + 1; j < s.length; j++)
            {
                if(s[i].compareTo(s[j]) < 0)
                {
                    String temp = s[i];
                            s[i] = s[j];
                            s[j] = temp;

                }
            }
        }

        for(int i = 0; i < s.length; i++)
        {
            char[] chars = s[i].toCharArray();
            Arrays.sort(chars);
            System.out.println(chars);

        }


    }
}

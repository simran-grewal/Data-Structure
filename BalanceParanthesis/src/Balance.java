import java.util.Scanner;

/**
 * Created by i_amg on 09-09-2016.
 */
public class Balance
{
    char[] stack = new char[100];
    int top = -1;

    void push(char c)
    {
        stack[++top] = c;
    }
    void pop()
    {
        top--;
    }
    boolean Isempty()
    {
       if(top == -1) return true;
        else
           return false;
    }
    boolean Matched(char open, char close)
    {
        if(open == '{' && close == '}') return true;
        if(open == '[' && close == ']') return true;
        if(open == '(' && close == ')') return true;
        return false;
    }
    boolean IsBalanced(char[] str)
    {
        int i;
        for(i = 0; i < str.length; i++)
        {
            if(str[i] == '{' || str[i] == '(' || str[i] == '[')
            {
                push(str[i]);
            }
            if(str[i] == '}' || str[i] == ')' || str[i] == ']')
            {
                if(Isempty() == true || Matched(str[top], str[i]) == false)
                {
                    return false;
                }
                else
                    pop();
            }

        }

        if(Isempty() == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        char[] str = s.next().toCharArray();
        Balance obj = new Balance();
        if(obj.IsBalanced(str) == true)
        {
            System.out.println("Given string is balanced");
        }
        else
        {
            System.out.println("Not Balanced");
        }

    }
}

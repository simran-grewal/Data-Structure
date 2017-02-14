/**
 * Created by i_amg on 08-09-2016.
 */
class stack
{
    private int top = -1;
    private int[] stack = new int[1];
    private void Expand()
    {
        int[] temp = new  int[2 * stack.length];
        for(int i = 0; i < stack.length; i++)
        {
            temp[i] = stack[i];
        }

        stack = temp;
    }
    public void push(int data)
    {
        if(top == stack.length - 1)
        {
            //System.out.println("HELLO");
            Expand();
        }
        stack[++top] = data;

    }
    private void Shrink()
    {
        int[] temp = new int[stack.length/2];
        for(int i = 0; i < temp.length; i++)
        {
            temp[i] = stack[i];
        }

        stack = temp;

    }
    public int pop()
    {
        if(top == -1)
        {
            System.out.println("Stack Is Empty");
            return 0;
        }
        if(top == (stack.length - 1)/4)
        {
            Shrink();
        }

      return stack[top--];
    }


    void Display()
    {
        for(int i : stack)
        {
            System.out.println(i);
        }
    }
}
public class DynamicStack
{

    public static void main(String[] args)
    {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(2);
        s.push(3);


        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());



    }
}

/**
 * Created by i_amg on 08-09-2016.
 */
public class Stack {
    int max = 1;
    int top = 0;
    int[] stack = new int[max];

    void Expand() {
        max = 2 * max;
        int[] temp = new int[max];
        for (int i = 0; i < top; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void push(int data) {
        if (top == max) {
            Expand();
        }
        stack[top++] = data;
    }

    void Display()
    {
        for (int i = 0; i < top; i++)
            System.out.println(" " + stack[i]);
    }

    void pop()
    {
        System.out.println(stack[--top]);

    }
    public static void main(String[] args)
    {
            Stack obj = new Stack();

            obj.push(1);
            obj.push(2);
            obj.push(3);
            obj.push(4);
            obj.push(5);
       // System.out.println("Top="+ obj.top);
            obj.Display();

            obj.pop();

    }
}

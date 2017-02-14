/**
 * Created by i_amg on 07-09-2016.
 */
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    void setData(int data)
    {
        this.data = data;
    }
    void setNext(Node next)
    {
        this.next = next;
    }
    Node getnext()
    {
        return this.next;
    }
    int getData()
    {
        return this.data;
    }
}

class LinkList
{
    Node head;
    LinkList()
    {
        head = null;
    }
    void Insert_Begin(int data)
    {
        Node New = new Node(data);
        if(head == null)
        {
            head = New;
        }
        else
        {
            New.setNext(head);
            head = New;
        }
    }

    void Display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(" "+temp.getData());
            temp = temp.getnext();
        }
    }

    void Reverse(Node head)
    {
        if(head == null) return;

        if(head.getnext() == null)
        {
            this.head = head;
            return;
        }

        Reverse(head.getnext());
        head.getnext().setNext(head);
        head.next = null;
    }

    Node Reverse_Itr(Node head)
    {
        Node prev, next, curr;
        curr = head;
        prev = null;
        while (curr != null)
        {
            next = curr.getnext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    void Remove_Duplicacy()
    {
        Node ptr = this.head;
        while (ptr != null)
        {
            while  ( ptr.getnext() != null && ptr.getData() == ptr.getnext().getData())
            {
                ptr.setNext(ptr.getnext().getnext());

            }

           ptr= ptr.getnext();
        }


    }

    void Remove_Redundency()
    {
        Node ptr1 = head;
        while (ptr1.getnext() != null  && ptr1 != null)
        {
            Node ptr2 = ptr1;
            while (ptr2.getnext() != null)
            {
                if(ptr1.getData() == ptr2.getnext().getData())
                {
                    ptr2.setNext(ptr2.getnext().getnext());
                }
                else
                {
                    ptr2 = ptr2.getnext();

                }

           }
              ptr1= ptr1.getnext();
        }
    }

        boolean Compare(Node Ist, Node Sec)
        {
            while (Ist != null && Sec != null)
            {
                if(Ist.getData() == Sec.getData()) {
                    Ist = Ist.getnext();
                    Sec = Sec.getnext();
                }
                else
                    return false;
            }

            if(Ist == null && Sec == null)
                return true;
            else
                return false;
        }
    boolean IsPalindrome()
    {
        if(head == null || head.getnext() == null) return true;

        Node Slow_ptr, Fast_ptr, Second_half, Prev_ToSlow = head;
        Slow_ptr = head;
        Fast_ptr = head;
        while (Fast_ptr.getnext() != null && Fast_ptr != null)
        {
            Fast_ptr.setNext(Fast_ptr.getnext().getnext());
            Prev_ToSlow = Slow_ptr;
            Slow_ptr = Slow_ptr.getnext();

        }

        if(Fast_ptr != null)
        {
            Slow_ptr = Slow_ptr.getnext();

        }

        Second_half = Slow_ptr;
        Prev_ToSlow.setNext(null);

        Second_half =  Reverse_Itr(Second_half);

        if(Compare(head, Second_half) == true)
            return true;
        else
            return  false;
    }
}
public class RemoveDuplicate
{
    public static void main(String[] args)
    {
        LinkList obj = new LinkList();
        obj.Insert_Begin(1);
        obj.Insert_Begin(5);
        obj.Insert_Begin(1);
        obj.Insert_Begin(2);
        obj.Insert_Begin(3);
        obj.Insert_Begin(5);
        obj.Insert_Begin(3);
        obj.Insert_Begin(1);
        obj.Insert_Begin(1);
        obj.Display();

        //obj.Reverse(obj.head);
        //obj.Reverse_Itr();
        System.out.println();
        //obj.Remove_Duplicacy();
  //      obj.Remove_Redundency();
        boolean res =  obj.IsPalindrome();
        //obj.Display();
        System.out.println(res);

    }
}

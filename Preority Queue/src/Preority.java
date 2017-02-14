import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by i_amg on 13-10-2016.
 */
public class Preority
{
    public static void main(String[] args)
    {
        Queue<Integer> queue = new PriorityQueue<Integer>(-);
        queue.add(23);
        queue.add(55);
        queue.add(10);
        System.out.println(queue.poll());
    }
}

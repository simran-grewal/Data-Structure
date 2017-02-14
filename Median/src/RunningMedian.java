/**
 * Created by i_amg on 17-10-2016.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Heap {

    PriorityQueue<Integer> max_heap = new PriorityQueue<Integer>(100, Collections.reverseOrder());
    PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();

    double[] findMedian(int arr[]) {
        double d[] = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (max_heap.size() == 0 || arr[i] < max_heap.peek()) {
                max_heap.add(arr[i]);
            } else {
                min_heap.add(arr[i]);
            }
            balance();
            d[i] = find();

        }
        return d;

    }

    private void balance() {

        if ((max_heap.size() - min_heap.size()) >= 2) {
            min_heap.add(max_heap.poll());
        } else if ((min_heap.size() - max_heap.size()) >= 2) {
            max_heap.add(min_heap.poll());
        }

    }

    private double find() {
        if (max_heap.size() == min_heap.size()) {
            return (((double) max_heap.peek() + (double) min_heap.peek()) / 2);
        } else if (max_heap.size() > min_heap.size()) {
            return max_heap.peek();
        } else {
            return min_heap.peek();
        }
    }
}

public class RunningMedian {

    public static void main(String args[]) throws Exception {
        Heap h = new Heap();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        double arr2[] = new double[n];
        arr2 = h.findMedian(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(arr2[i]);
        }



    }
}

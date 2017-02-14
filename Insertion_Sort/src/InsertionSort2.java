import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Created by i_amg on 10-09-2016.
 */
public class InsertionSort2 {
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void Sort(int[] arr, int n)
    {
        InsertionSort obj = new InsertionSort();
        int i;
        for (i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
               swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 5, 8, 3};
        Sort(arr, arr.length);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
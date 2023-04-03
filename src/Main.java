import Day2.RecursionFindMaxVar;
import Day2.MergeSort;
import Day2.SmallSum;
import Day2.QuickSort;
import Code03.HeapSort;
import Code03.RadixSort;
import Day2.NewQuickSort;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] myTest = {1, 32, 201, 4};

        NewQuickSort nq = new NewQuickSort();
        nq.quickSort(myTest);
    }
}


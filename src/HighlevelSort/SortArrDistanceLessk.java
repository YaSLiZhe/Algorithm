package HighlevelSort;
import java.util.PriorityQueue;
//利用最小堆的特性和k位置必取到最小值
public class SortArrDistanceLessk {
    public void sortArrDistanceLessK(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(; index <= Math.min(k,arr.length); index++){
            heap.add(arr[index]);
        }
        int i = 0;
        for(; index < arr.length; i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}

package HighlevelSort;

public class HeapSort {
    public void heapSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            heapInsert(nums, i);
        }
        //or for(int i = nums.length -1; i>=0; i--)
        //{heapify(nums,i,nums.length);
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while(heapSize > 0){
            heapify(nums, 0 ,heapSize);
            swap(nums, 0, --heapSize);
        }

    }

    //已经是一个堆，但是交换了第一个元素不同，所以进行heapify使之再次成为堆
    private void heapify(int[] nums, int index,int heapSize){
        int leftChild = 2 * index + 1;//左孩子的下标
       // int largest;
        while(leftChild < heapSize){
            int largest = nums[leftChild+1]>nums[leftChild] && leftChild+1 < heapSize?leftChild+1:leftChild;
            largest = nums[largest] <= nums[index]? index: largest;
            if(largest == index){
                break;
            }
            swap(nums,largest,index);
            index = largest;
            leftChild = index*2 +1;
            }
    }
    private void heapInsert(int[] nums, int index){ //某个数在index位置，让这个index位置的数来到合适的地方
//index需要和其父节点进行比较，父节点的下标值可以算为(index - 1)/2
        while(nums[(index - 1)/2] < nums[index]){
             swap(nums, index, (index-1)/2);
             index = (index - 1)/2;
        }

    }

    private void swap(int[] nums, int i , int j){
        int swapTemp = 0;
        swapTemp = nums[i];
        nums[i] = nums[j];
        nums[j] = swapTemp;
    }
}

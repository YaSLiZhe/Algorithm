package AdvancedSort;
//[3,5,6,2,4,4]
//[]
public class NewQuickSort {
    public void quickSort(int[] nums){
        if(nums == null || nums.length < 2){
            return ;
        }
        quickSort(nums, 0 , nums.length - 1);
        for(int arr: nums){
            System.out.println(arr);
        }
    }

    private void quickSort(int[] nums, int L, int R){
        if(L < R){
            int randomNum = L + (int)(Math.floor(Math.random()*(R - L + 1)));
            swap(nums, randomNum, R);
            int[] p = partatition(nums, L, R);
            quickSort(nums, L, p[0] - 1);
            quickSort(nums, p[1] + 1, R);
        }
    }

    private int[] partatition(int[] nums, int L, int R){
        int p1 = L - 1;
        int p2 = R;
        while(L < p2){
            if(nums[L] < nums[R]){
                swap(nums,++p1,L++);
            }

            else if(nums[L] > nums[R]){
                swap(nums,--p2,L);
            }
            else L++;
        }
        swap(nums, R, p2);
        return new int[] {p1, p2};
    }

        private void swap(int[] nums, int index1, int index2){
            int swapTemp = 0;
            swapTemp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = swapTemp;
        }

}

package CommonSort;

public class BubbleSort {
    //good
    public void bubbleSort(int[] nums){
        boolean flag = false;
        for(int i = 0; i < nums.length; i++){
            for(int j= 0; j <nums.length - 1- i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
        for(int arr:nums){
            System.out.print(arr);
            System.out.print(" ");
        }
    }
}

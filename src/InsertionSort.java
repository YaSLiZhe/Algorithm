public class InsertionSort {
    public void insertSort(int[] nums){
        int length = nums.length;
        for(int i = 1; i < length; i++ ){
            int current = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > current){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = current;
        }
        for(int arr:nums){
            System.out.print(arr);
            System.out.print((" "));
        }
    }
}

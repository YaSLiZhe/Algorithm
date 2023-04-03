package Day2;

public class MergeSort2 {
    public void mergeSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        process(nums, 0 , nums.length - 1);
    }
    private void process(int[] nums, int L, int R){
        if(L == R){
            return;
        }
        int mid = L + (R-L)>>1;
        process(nums,L,mid);
        process(nums,mid+1,R);
        merge(nums,mid,L,R);
    }
    private void merge(int[] nums, int mid, int L, int R){
        int[] help = new int[R - L +1];
        int p1 = L;
        int p2 = mid+1;
        int i = 0;
        while(p1<=mid && p2 <= R){
            if(nums[p1]<=nums[p2]){
                help[i] = nums[p1];
                i++;p1++;
            }
            else{
                help[i] = nums[p2];
                i++;p2++;
            }
        }
        while(p1 <= mid){
            help[i] = nums[p1];
            i++;p1++;
        }
        while(p2 <= R){
            help[i]=nums[p2];
            i++;p2++;
        }
        for(i = 0;i < help.length;i++){
            nums[L+i]=help[i];
        }
    }
}

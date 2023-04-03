package Day2;
//快速排序算法
//可以理解为推土机一样来排序，其核心是partition过程，即根据一个数将大于这个数的放在左边，小于的放在右边
//然后递归左右两边直至排序完成
//[1,3,2,4]
//1. random选取一个数字比如为3
//2.调整顺序为[1,4,2,3]
//3.定义两个指针来存放左右边界p1 = L-1,p2 = R(一般是将p2设置为R -1，但此题可以左右排好序将最后的3和p2交换位置）
//partition返回一个长度为二的数组p，p[0] -1为左数组最后一个数的index，p[1] +1为右数组第一个数index
public class QuickSort {
    public void quickSort(int[] nums){
        if(nums == null||nums.length<2){
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int L, int R) {
        //工程上对算算法的改进，小范围范围的时候利用插入排序o(n2)插入排序
        //If(L>R-60){
        //在nums[L,R]进行插入排序，小样本量跑得快
   // }
        if(L < R){
            int randomNum = L + (int)(Math.random() * (R -L + 1) );
            //swap randomNum and rightest nums position
            swap(nums, randomNum, R);
            //find out right point of left array and left point of right array
            //partition also can divide this array according to pivot value
            int[] p = partition(nums, L, R);
            quickSort(nums,L,p[0]-1);
            quickSort(nums, p[1] +1,R);
        }
    }

    private int[] partition(int[] nums, int L, int R){
        int p1 = L-1;
        int p2 = R;
        while(L < p2){
            if(nums[L] < nums[R]){
                swap(nums, ++p1, L++);
            } else if (nums[L] > nums[R]) {
                swap(nums, --p2, L);
            } else{
                L++;
            }
        }
        swap(nums,p2,R);
        return new int[] {p1+1, p2};
    }


    private  void swap(int[] nums, int i,int j){
        int swapTemp = 0;
        swapTemp = nums[i];
        nums[i] = nums[j];
        nums[j] = swapTemp;
    }
}

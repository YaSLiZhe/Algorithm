package AdvancedSort;
//小和问题的解法，小和问题即一数组如{1,3,2,4}，看每个数的左侧小于这个数的数字有多少，加起来。我们可以将其转化为一个数字看右侧
//大于这个数的数有多少。利用归并排序的性质，因为归并的时候左右都排好顺序，所以比较容易计算。
//这个例子中，对于1有3，2，4比它大。对于3有4比它大。对于2有4比它大。所以小和为1*3+3+2=8.
public class SmallSum {
    public int smallSum(int[] array){
        if(array == null){
            return 0;
        }
        if(array.length == 1){
            return 0;
        }
        return process(array, 0 , array.length-1);
    }
    private int process(int[] array,int L, int R){
        if(L == R){
            return 0;
        }
        int M = L +((R - L)>>1);
        return process(array,L,M) + process(array,M+1, R) + merge(array, L, M, R);
    }
    private int merge(int[] array, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int res = 0;
        while(p1 <= M && p2 <= R){
           if(array[p1] < array[p2]){
               //对于两个排好序的比如{1，2，4}和{2,3},因为是有序的，array[p1]=1,array[p2] = 2, 此时array[p1]肯定小于后面的p2
               res += array[p1] * (R - p2 +1);
               help[i] = array[p1];
               p1++;i++;
           }
           else{
               help[i] = array[p2];
               p2++;i++;
           }
        }
        while(p1 <= M){
            help[i] = array[p1];
            p1++;i++;
        }
        while(p2 <= R){
            help[i] = array[p2];
            p2++;i++;
        }
        for(i = 0; i < help.length ;i++){
            array[L + i] = help[i];
        }
        return res;
    }
}

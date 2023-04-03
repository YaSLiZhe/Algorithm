package Day2;

public class MergeSort {
    public void mergeSort(int[] array){
        //先判断是否为空和数组长度是否为1，属于这两种情况可以直接返回空
        if(array == null || array.length < 2){
            return;
        }
        //process函数作用为对这个数组进行排序，因为后面涉及到二分数组进行归并排序，所以多两个参数为数组左和右
        process(array,0,array.length-1);
    }
    private void process(int[] array,int L, int R){
        //递归出口，当二分至L == R的时候执行下一步操作
        if(L == R){
            return;
        }
        //为了防止R+L溢出，所以使用R-L>>1
        int mid = L + ((R-L)>>1);
        //此处为归并算法核心，即左侧排好序，右侧排好序，最后进行合并
        process(array,L,mid);
        process(array,mid+1,R);
        merge(array,L,mid,R);
    }

    private void merge(int[] array,int L, int M, int R){
        //开辟一个help数组来存储归并结果
        int[] help = new int[R - L + 1];
        int i = 0;
        //双指针，当p1指针和p2都在自己的排好序的结果中的时候，比较p1和p2对应的数组值
        //p1对应的值小于p2对应的值就将p1对应的值压入help中，并且i和p1均右移
        //反之，压入p2对应的值
        int p1 = L;
        int p2 = M+1;
        while(p1 <= M && p2 <= R){

          if(array[p1] <= array[p2]){
              help[i] = array[p1];
              i++;
              p1++;
          }
          else{
              help[i] = array[p2];
              i++;
              p2++;
          }
        }
        //当p1或者p2越界压入剩下的值
        while(p1 <= M){
            help[i] = array[p1];
            i++; p1++;
        }
        while(p2 <= R){
            help[i] = array[p2];
            i++;p2++;
        }
        //遍历将值传入array
        for(i = 0;i < help.length;i++){
            array[L+i] = help[i];
        }
    }
}

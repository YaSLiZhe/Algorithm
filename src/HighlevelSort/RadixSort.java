package HighlevelSort;
//基数排序
//1.基数排序就是根据数字的最后一位从后往前进行排序
//2. 首先找到数组中含有位数最多的那个数字，并用maxbits求出其位数
//3. 求出位数后我们就知道需要遍历多少次可以完成
//4. 定义bucket等于数组大小，存储每次的位数
//5. 开始遍历，例子[32,3,56,742]. 我们去找到最大位数（742）为3，所以我们需要三次循环。第一次循环32找到数字2将其计入count数组中count[2]位置然后进行前面相加
//以此类推，count变为[0,0,2,3,0,0,4,0,0,0],我们从后往前遍历742符合最后位数为2，因count[2]=2,我们吧742存入bucket[2],56对应count[6]=4
//我们存入bucket[3],最后bucket变为[32,742,3,56].继续找倒数第二位的数，找完bucket即为排好序的数组，注意每次循环count必须归零。
public class RadixSort {
    public void radixSort(int[] arr){
        if(arr == null|| arr.length <2){
            return;
        }
        radixSort(arr, 0, arr.length-1, maxBits(arr));
    }

    private int maxBits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i],max);
        }
        int res= 0;
        while(max != 0){
            max = max/10;
            res++;
        }
        return res;
    }

    private void radixSort(int[] arr, int start, int end, int maxBits){
        int[] bucket = new int[end - start + 1];
        for(int d = 1; d <= maxBits; d++){
            int[] count = new int[10];// each loop this value need be updated
            for (int i = start; i <= end; i++){ //count array store each bit's count
                int j = getDigit(arr[i] , d);
                count[j]++;
            }

            for (int i = 1; i < count.length; i++){
                count[i] = count[i] + count[i - 1];
            }

            for(int i = end; i >= start; i--){
                int j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
//            for(int i = start, j = 0; i <= end; i++){
//                arr[i] = bucket[j++];
//            }
        }
        for(int i = start, j = 0; i <= end; i++){
            arr[i] = bucket[j++];
        }

    }

    private int getDigit(int x, int d){
        int res = (x / ((int)Math.pow(10,d-1))) % 10;
        return  res;
    }
}

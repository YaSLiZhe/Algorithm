package CommonSort;

public class RecursionFindMaxVar {
  public int find(int[] array){
      if(array == null){
          return 0;
      }
      if(array.length == 1){
          return array[0];
      }
      return process(array,0,array.length -1);
  }
  private int process(int[] array, int L, int R){
      if(L == R){
          return array[L];
      }
      int M = L + ((R - L)>>1);
      int leftMax = process(array,L,M);
      int rightMax = process(array,M+1,R);
      return Math.max(leftMax,rightMax);
  }
}
